package br.edu.unidesc.exercicio.oat.crud_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoController implements IAluno {

    //Lista de Alunos
    private List<Aluno> alunos = new ArrayList<Aluno>();

    @Override
    public Aluno criarAluno() {

        //Instancia de Aluno
        Aluno aluno = new Aluno();

        //Instancia de scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        //Atribuição de valores por entrada
        System.out.println("\n\nInforme o CPF: ");
        aluno.setCpf(scanner.nextLine());
        System.out.println("Infornme o Nome: ");
        aluno.setNome(scanner.nextLine());
        System.out.println("Informe o Curso: ");
        aluno.setCurso(scanner.nextLine());
        aluno.setMatricula();

        //Inclusão do objeto aluno ao List
        alunos.add(aluno);

        //Retorno do objeto criado
        return aluno;
    }

    @Override
    public void buscarAluno(String cpf) {

        //Atributo de verificação
        boolean alunoEncontrado = false;

        System.out.println("\n\nBuscando por aluno...\n\n");

        //Busca pelo objeto com mesma cpf que o informado pelo usuario
        for (Aluno aluno : alunos) {
            if (cpf.equals(aluno.getCpf())) {
                //Impressão do objeto encontrado
                System.out.println(aluno.getNome());
                System.out.println(aluno.getCpf());
                System.out.println(aluno.getCurso());
                System.out.println(aluno.getMatricula());

                //Alteração da verificação
                alunoEncontrado = true;
            }
        }
        //Verifica se o objeto não foi encontrado
        if (!alunoEncontrado) {
            System.out.println("\n\nCPF Invalido!\n\n");
        }
    }

    @Override
    public void atualizarAluno(String cpf) {

        //Atributo de verificação
        boolean alunoEncontrado = false;

        //Instancia de scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        //Busca pelo objeto com mesma cpf que o informado pelo usuario
        for (Aluno aluno : alunos) {
            if (cpf.equals(aluno.getCpf())) {
                //Atribuição de novos valores
                System.out.println("\n\nInforme o novo CPF: ");
                aluno.setCpf(scanner.nextLine());
                System.out.println("Infornme o novo Nome: ");
                aluno.setNome(scanner.nextLine());
                System.out.println("Informe o novo Curso: ");
                aluno.setCurso(scanner.nextLine());

                //Alteração da verificação
                alunoEncontrado = true;
            }
        }
        //Verifica se o objeto não foi encontrado
        if (!alunoEncontrado) {
            System.out.println("\n\nCPF Invalido!\n\n");
        }
    }

    @Override
    public void deletarAluno(String cpf) {

        //Atributo de verificação
        boolean alunoEncontrado = false;

        //Instancia de scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        //Busca pelo objeto com mesma cpf que o informado pelo usuario
        for (Aluno aluno : alunos) {
            if (cpf.equals(aluno.getCpf())) {
                System.out.println("\n\nAluno " + aluno.getNome() + " deletado com sucesso!\n\n");

                //Alterando os valores para nulo (*Não descobri como remover um objeto de uma List)
                aluno.setCurso(null);
                aluno.setNome(null);
                aluno.setCpf(null);

                //Alteração da verificação
                alunoEncontrado = true;
            }
        }
        //Verifica se o objeto não foi encontrado
        if (!alunoEncontrado) {
            System.out.println("\n\nCPF Invalido!\n\n");
        }
    }
}
