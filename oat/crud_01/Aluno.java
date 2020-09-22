package br.edu.unidesc.exercicio.oat.crud_01;

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
        Random random = new Random();
        Integer aleatorio = random.nextInt();

        this.matricula = aleatorio.toString();
    }
}
