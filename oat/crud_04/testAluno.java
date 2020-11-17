package br.edu.unidesc.exercicio.oat.crud_04;

import br.edu.unidesc.exercicio.oat.crud_04.controller.AlunoController;
import br.edu.unidesc.exercicio.oat.crud_04.entidades.Aluno;

import java.util.Scanner;

public class testAluno {

    public static void main(String[] args) {

        int quantAluno;
        String op, temp, conteudo;

        Aluno aluno;
        Scanner scanner = new Scanner(System.in);
        AlunoController controller = new AlunoController();

        //Menu de seleção
        do {
            System.out.println("\n====MENU DE OPÇÕES====\n");
            System.out.println("1) Adicionar novo aluno!");
            System.out.println("2) Buscar alunos!");
            System.out.println("3) Atualizar alunos!");
            System.out.println("4) Deletar alunos!");
            System.out.println("0) Sair!");
            op = scanner.nextLine();

            switch (op) {
                //Sair!
                case "0":
                    System.out.println("\n\nFinalizando programa...\n\n");
                    break;
                //Adicionar novo aluno!
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

                        //Mensagem de sucesso
                        System.out.println("\n\nAluno adicionado com sucesso!\n\n");
                    }
                    break;
                //Buscar alunos!
                case "2":
                    System.out.println("Informe o CPF do aluno deseja buscar: ");
                    //Chamada do metodo READ
                    conteudo = controller.lerAluno(scanner.nextLine());
                    //Verificando se o arquivo para leitura foi encontrado
                    if (conteudo != null) {
                        //Mensagem de sucesso
                        System.out.println("\n\nAluno encontrado com sucesso:\n\n");
                        //Imprimindo conteudo encontrado
                        System.out.println(conteudo);
                    } else
                        //Mensagem de erro
                        System.out.println("\n\nERROR CPF invalido ou inexistente\n\n");
                    break;
                //Atualizar alunos!;
                case "3":
                    System.out.println("Informe o CPF do aluno deseja atualizar: ");
                    String cpf = scanner.nextLine();
                    //Verificando se existe algum aluno com este CPF
                    if (controller.lerAluno(cpf) != null) {
                        //Capturando novos dados
                        System.out.println("Informe o novo Nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Informe o novo Curso: ");
                        String curso = scanner.nextLine();

                        //Chamada do metodo UPDATE
                        controller.atualizarAluno(cpf, nome, curso);

                        //Mensagem de sucesso
                        System.out.println("\n\nAluno atualizado com sucesso!\n\n");
                    } else
                        //Mensagem de erro
                        System.out.println("\n\nERROR arquivo não existente\n\n");
                    break;
                //Deletar alunos!
                case "4":
                    System.out.println("Informe o CPF do aluno deseja atualizar: ");
                    cpf = scanner.nextLine();
                    //Verificando se existe algum aluno com este CPF
                    if (controller.lerAluno(cpf) != null) {
                        //Chamada do metodo DELETE
                        controller.deletarAluno(cpf);
                        System.out.println("\n\nAluno deletado com sucesso!\n\n");
                    } else {
                        //Mensagem de erro
                        System.out.println("\n\nERROR CPF invalido ou inexistente\n\n");
                    }
                    break;
                //Nenhuma das opções
                default:
                    //Mensagem de erro
                    System.out.println("\n\nOpção invalida!\n\n");
            }
            //Verificação se a opção "Sair" foi selecionada
        } while (!op.equals("0"));
    }
}
