package br.edu.unidesc.exercicio.oat.crud_01;

public interface IAluno {

    Aluno criarAluno();                                                                //Create
    void buscarAluno(String cpf);                                                      //Read
    void atualizarAluno(String cpf);                                                   //Update
    void deletarAluno(String cpf);                                                     //Delete
}
