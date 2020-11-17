package br.edu.unidesc.exercicio.oat.crud_04.controller;

import br.edu.unidesc.exercicio.oat.crud_04.helper.ArquivoHelper;
import br.edu.unidesc.exercicio.oat.crud_04.helper.DatabaseHelper;
import br.edu.unidesc.exercicio.oat.crud_04.interfaces.IAluno;
import br.edu.unidesc.exercicio.oat.crud_04.entidades.Aluno;

public class AlunoController implements IAluno {

    //Metodo CREATE
    @Override
    public void criarAluno(Aluno aluno) {

        //Gerar uma nova matricula para o aluno
        aluno.setMatricula();

        //Chamando helper para adicionar novo registro no banco
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        databaseHelper.criarAluno(aluno);
    }

    //Metodo READ
    @Override
    public String lerAluno(String cpf) {

        //Chamando helper para ler um registro do banco
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        return databaseHelper.lerAluno(cpf);
    }

    //Metodo UPDATE
    @Override
    public void atualizarAluno(String cpf, String nome, String curso) {

        //Chamando helper para atualizar um registro do banco
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        databaseHelper.atualizarAluno(cpf, nome, curso);
    }

    //Metodo DELETE
    @Override
    public boolean deletarAluno(String cpf) {

        //Chamando helper para deletar um registro do banco
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        //Verificando se foi deletado com sucesso
        if(databaseHelper.deletarAluno(cpf))
            return true;
        return false;
    }
}
