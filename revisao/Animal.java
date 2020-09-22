package br.edu.unidesc.exercicio.revisao;

public class Animal {

    public String Teste;
    private String raca;
    private int idade;

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("Animal Emitindo som:");
    }

}
