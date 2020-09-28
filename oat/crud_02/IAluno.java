package br.edu.unidesc.exercicio.oat.crud_02;

public interface IAluno {

    Aluno criarAluno(Aluno aluno);                                                                //Create
    Aluno buscarAluno(String cpf);                                                      //Read
    Aluno atualizarAluno(Aluno aluno);                                                   //Update
    void deletarAluno(Aluno aluno);                                                     //Delete
}
