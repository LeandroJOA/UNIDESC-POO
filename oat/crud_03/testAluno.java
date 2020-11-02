package br.edu.unidesc.exercicio.oat.crud_03;

import br.edu.unidesc.exercicio.oat.crud_03.controller.AlunoController;
import br.edu.unidesc.exercicio.oat.crud_03.entidades.Aluno;

import java.util.Scanner;

public class testAluno {

    public static void main(String[] args) {

        int quantAluno;
        String op, temp, conteudo;

        Aluno aluno = new Aluno();
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
                    System.out.println("\n\nArquivo 'alunos' criado com sucesso!\n\n");
                    break;
                //Buscar alunos!
                case "2":
                    //Chamada do metodo READ
                    conteudo = controller.lerAluno();
                    //Verificando se o arquivo para leitura foi encontrado
                    if (conteudo != null) {
                        System.out.println("\n\nArquivo 'alunos' encontrado com sucesso:\n\n");
                        System.out.println(conteudo);
                    } else
                        System.out.println("\n\nERROR arquivo não existente\n\n");
                    break;
                //Atualizar alunos!;
                case "3":
                    //Verificando se o arquivo 'alunos' já existe
                    if (controller.lerAluno() != null) {
                        //Deletando arquivo existente
                        controller.deletarAluno();

                        //Gerando novo arquivo
                        System.out.println("Quantos novos alunos deseja adicionar? ");
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

                            //Chamada do metodo UPDATE
                            controller.atualizarAluno(aluno);

                            //Mensagem de sucesso
                            System.out.println("\n\nAluno adicionado com sucesso!\n\n");
                        }

                        //Mensagem de sucesso
                        System.out.println("\n\nArquivo 'alunos' alterado com sucesso!\n\n");
                    } else
                        System.out.println("\n\nERROR arquivo não existente\n\n");
                    break;
                //Deletar alunos!
                case "4":
                    //Verificando se o arquivo para exclusão foi encontrado
                    if (controller.deletarAluno())
                        System.out.println("\n\nArquivo 'alunos' deletado com sucesso!\n\n");
                    else
                        System.out.println("\n\nERROR arquivo não existente\n\n");
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
