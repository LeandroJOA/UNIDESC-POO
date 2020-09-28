package br.edu.unidesc.exercicio.oat.crud_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoController implements IAluno {

    //Lista de Alunos
    private List<Aluno> alunos = new ArrayList<Aluno>();

    @Override
    public Aluno criarAluno(Aluno aluno) {

        //Gerar uma nova matricula para o aluno
        aluno.setMatricula();

        //Adiciona o aluno recebido à uma lista
        alunos.add(aluno);

        //Mensagem de sucesso
        System.out.println("\n\nAluno adicionado com sucesso!\n\n");

        //Retorna o aluno criado
        return aluno;
    }

    @Override
    public Aluno buscarAluno(String cpf) {

        //Passa por todos os alunos existentes
        for (Aluno aluno : alunos) {
            //Retorna o aluno com mesmo CPF que o passado pelo usuario
            if (cpf.equals(aluno.getCpf())) {
                return aluno;
            }
        }
        //Retorna nulo caso não seja encontrado nenhum aluno
        return null;
    }

    @Override
    public Aluno atualizarAluno(Aluno aluno) {
        //Objeto para entrada de dados
        Scanner scanner = new Scanner(System.in);

        //Atribui um novo "Nome"
        System.out.println("Informe o novo Nome: ");
        aluno.setNome(scanner.nextLine());
        //Atribui um novo "Curso"
        System.out.println("Informe o novo Curso: ");
        aluno.setCurso(scanner.nextLine());

        //Mensagem de sucesso
        System.out.println("\n\nAluno atualizado com sucesso!\n\n");

        //Retorna o aluno atualizado
        return aluno;
    }

    @Override
    public void deletarAluno(Aluno aluno) {

        //Remove o aluno passado por parametro
        alunos.remove(aluno);

        //Mensagem de sucesso
        System.out.println("\n\nAluno deletado com sucesso!\n\n");
    }
}
