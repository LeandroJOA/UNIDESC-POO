package br.edu.unidesc.exercicio.oat.crud_03.interfaces;

import br.edu.unidesc.exercicio.oat.crud_03.entidades.Aluno;

import java.io.IOException;

public interface IAluno {

    void criarAluno(Aluno aluno);           //Create
    String lerAluno();                      //Read
    void atualizarAluno(Aluno aluno);       //Update
    boolean deletarAluno();                 //Delete
}