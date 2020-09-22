package br.edu.unidesc.exercicio.revisao;

public class Gato extends Animal {

    private boolean pedigree;
    private String cor;

    public boolean isPedigree() {
        return pedigree;
    }

    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void emitirSom() {
        System.out.println("\nMeeow... Puuurrrr...");
    }
}
