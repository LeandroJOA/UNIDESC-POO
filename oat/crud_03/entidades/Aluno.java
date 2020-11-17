package br.edu.unidesc.exercicio.oat.crud_03.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
        Integer aleatorio = random.nextInt((99 - 1) + 1) + 1;

        //Formatação do codigo para dois digitos
        String codigo = String.format("%02d", aleatorio);

        //Parte 3 - Geração do codigo do semestre
        LocalDateTime dateTime = LocalDateTime.now();
        //Captura do mes atual
        int mes = dateTime.getMonthValue();

        //Inicialização do codigo do semestre
        String semestre = "01";

        //Verificação caso o mês seja após junho
        if (mes > 6)
            semestre = "02";

        //Parte 4 - Geração da matricula com data + codigo + semestre (YYYYMMddHHmmss-RR-SS)
        this.matricula = dataMatricula + "-" + codigo + "-" + semestre;
    }
}