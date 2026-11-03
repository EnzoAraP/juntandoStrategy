package org.example;

public class Vaca {
    private int peso;

    public int getPeso() {
        return peso;
    }

    // Strategy: a vaca delega o ganho de peso ao silo recebido.
    public void comer(Silo silo, int quantidade) {
        this.peso += silo.alimentar(quantidade);
    }
}
