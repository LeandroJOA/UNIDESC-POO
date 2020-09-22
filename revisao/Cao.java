package br.edu.unidesc.exercicio.revisao;

public class Cao extends Animal {

    private String nome;
    private String sexo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void emitirSom() {
        System.out.println("\nAu! Au! AuAu! Au!...");
    }
}
