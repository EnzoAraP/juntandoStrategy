package org.example;

public class Fazenda {
    private int quantidade;
    public Fazenda(int quantidade){
        this.quantidade = quantidade;
    }
    public int alimentar(Silo silo){return silo.alimentar(quantidade); }
}
