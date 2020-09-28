package br.edu.unidesc.exercicio.oat.crud_02;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Aluno {

    private String cpf;
    private String nome;
    private String curso;
    private String matricula;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula() {
        //Parte 1 - Geração da data da matricula
        Date date = new Date();

        //Formatação da data em "AnoMêsDiaHoraMinutoSegundo" (YYYYMMddHHmmss)
        DateFormat formatador = new SimpleDateFormat("YYYYMMddHHmmss");
        String dataMatricula = formatador.format(date);

        //Parte 2 - Geração do codigo da matricula (RR)
        Random random = new Random();

        //Formula para valores entre 1 e 100: ((max - min) + 1) + min;
        Integer aleatorio = random.nextInt((100 - 1) + 1) + 1;

        //Formatação do codigo para dois digitos
        String codigo = String.format("%02d", aleatorio);

        //Parte 3 - Geração do semestre da matricula (SS)
        //Formula para valores 1 ou 2: ((max - min) + 1) + min;
        aleatorio = random.nextInt((2 - 1) + 1) + 1;

        //Formatação do semestre para dois digitos
        String semetre = String.format("%02d", aleatorio);

        //Parte 4 - Geração da matricula com data + codigo + semestre (YYYYMMddHHmmss-RR-SS)
        this.matricula = dataMatricula + "-" + codigo + "-" + semetre;
    }
}
