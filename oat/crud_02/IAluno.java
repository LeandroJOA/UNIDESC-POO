package br.edu.unidesc.exercicio.oat.crud_02;

public interface IAluno {

    void criarAluno(Aluno aluno);                   //Create
    Aluno buscarAluno(String cpf);                  //Read
    void atualizarAluno(Aluno aluno);               //Update
    void deletarAluno(Aluno aluno);                 //Delete
}
