package br.edu.unidesc.exercicio.revisao;

public class testAnimal {

    public static void main(String[] args) {

        Animal animal = new Animal();

        animal.emitirSom();


        Cao cao = new Cao();

        cao.setNome("Tobby");
        cao.setSexo("Macho");
        cao.setIdade(40);
        cao.setRaca("Shih tzu");

        cao.emitirSom();

        Gato gato = new Gato();

        gato.setPedigree(true);
        gato.setCor("Prateado");
        gato.setIdade(28);
        gato.setRaca("Persa");

        gato.emitirSom();
    }
}
