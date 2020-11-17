package br.edu.unidesc.exercicio.oat.crud_03.controller;

import br.edu.unidesc.exercicio.oat.crud_03.helper.ArquivoHelper;
import br.edu.unidesc.exercicio.oat.crud_03.interfaces.IAluno;
import br.edu.unidesc.exercicio.oat.crud_03.entidades.Aluno;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AlunoController implements IAluno {

    //Metodo CREATE
    @Override
    public void criarAluno(Aluno aluno) {

        //Gerar uma nova matricula para o aluno
        aluno.setMatricula();

        //Chamando helper para gravar arquivo
        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        arquivoHelper.gravarCSV(aluno);
    }

    //Metodo READ
    @Override
    public String lerAluno() {

        //Chamando helper para ler arquivo
        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        return arquivoHelper.lerCSV();
    }

    //Metodo UPDATE
    @Override
    public void atualizarAluno(Aluno aluno) {

        //Gerar uma nova matricula para o aluno
        aluno.setMatricula();

        //Chamando helper para gravar arquivo
        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        arquivoHelper.gravarCSV(aluno);
    }

    //Metodo DELETE
    @Override
    public boolean deletarAluno() {

        //Chamando helper para deletar arquivo
        ArquivoHelper arquivoHelper = ArquivoHelper.getInstance();
        return arquivoHelper.deletarCSV();
    }
}