package br.edu.unidesc.exercicio.oat.crud_04.interfaces;

import br.edu.unidesc.exercicio.oat.crud_04.entidades.Aluno;

public interface IAluno {

    void criarAluno(Aluno aluno);           //Create
    String lerAluno(String cpf);                      //Read
    void atualizarAluno(String cpf, String nome, String curso);       //Update
    boolean deletarAluno(String cpf);                 //Delete
}
