package br.edu.unidesc.exercicio.oat.crud_02;

import java.util.Scanner;

public class testAluno {

    public static void main(String[] args) {

        int quantAluno;
        String op, temp;

        Aluno aluno = new Aluno();
        Scanner scanner = new Scanner(System.in);
        AlunoController controller = new AlunoController();

        //Menu de seleção
        do {
            System.out.println("\n====MENU DE OPÇÕES====\n");
            System.out.println("1) Adicionar novo aluno!");
            System.out.println("2) Buscar aluno!");
            System.out.println("3) Atualizar aluno!");
            System.out.println("4) Deletar aluno!");
            System.out.println("0) Sair!");
            op = scanner.nextLine();

            switch (op) {
                case "0":
                    System.out.println("\n\nFinalizando programa...\n\n");
                    break;
                case "1":
                    System.out.println("Quantos alunos deseja adicionar? ");
                    temp = scanner.nextLine();
                    quantAluno = Integer.parseInt(temp);

                    //Repetição para cada novo aluno
                    for (int i = 0; i < quantAluno; i++) {
                        //Reset do aluno
                        aluno = new Aluno();

                        System.out.println("Informe o Nome: ");
                        aluno.setNome(scanner.nextLine());
                        System.out.println("Informe o CPF: ");
                        aluno.setCpf(scanner.nextLine());
                        System.out.println("Informe o Curso: ");
                        aluno.setCurso(scanner.nextLine());

                        //Chamada do metodo CREATE
                        controller.criarAluno(aluno);
                    }
                    break;
                case "2":
                    //Busca do aluno pelo seu CPF
                    System.out.println("Informe o CPF do aluno desejado: ");
                    aluno = controller.buscarAluno(scanner.nextLine());
                    //Verificação se o aluno buscado existe
                    if (aluno != null) {
                        //Feedback visual para o usuario
                        System.out.println("\n\nAluno encontrado com sucesso: \n\n");
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("CPF: " + aluno.getCpf());
                        System.out.println("Curso: " + aluno.getCurso());
                        System.out.println("Matricula: " + aluno.getMatricula());
                    } else {
                        //Mensagem de fracasso
                        System.out.println("\n\nCPF invalido ou inexsistente!\n\n");
                    }
                    break;
                case "3":
                    //Busca do aluno pelo seu CPF
                    System.out.println("Informe o CPF do aluno desejado: ");
                    aluno = controller.buscarAluno(scanner.nextLine());
                    //Verificação se o aluno buscado existe
                    if (aluno != null) {
                        //Chamada do metodo UPDATE
                        controller.atualizarAluno(aluno);
                    } else {
                        //Mensagem de fracasso
                        System.out.println("\n\nCPF invalido ou inexsistente!\n\n");
                    }
                    break;
                case "4":
                    //Busca do aluno pelo seu CPF
                    System.out.println("Informe o CPF do aluno desejado: ");
                    aluno = controller.buscarAluno(scanner.nextLine());
                    //Verificação se o aluno buscado existe
                    if (aluno != null) {
                        //Chamada do metodo DELETE
                        controller.deletarAluno(aluno);
                    } else {
                        //Mensagem de fracasso
                        System.out.println("\n\nCPF invalido ou inexsistente!\n\n");
                    }
                    break;
                default:
                    //Mensagem de erro
                    System.out.println("\n\nOpção invalida!\n\n");
            }
            //Verificação se a opção "Sair" foi selecionada
        } while (!op.equals("0"));
    }
}
