package br.edu.unidesc.exercicio.oat.crud_01;

public class testAluno {

    public static void main(String[] args) {

        AlunoController alunoController = new AlunoController();

        alunoController.criarAluno();

        alunoController.buscarAluno("1");

        alunoController.atualizarAluno("1");

        alunoController.buscarAluno("1");

        alunoController.deletarAluno("1");

        alunoController.buscarAluno("1");

    }
}
