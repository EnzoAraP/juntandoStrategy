package org.example;

public class Main {
    public static void main(String[] args) {
        SiloFactory fabrica = SiloFactory.getInstance();
        Vaca vaca = new Vaca();
        vaca.comer(fabrica.obterSilo("Trigo"), 1);
        vaca.comer(fabrica.obterSilo("Milho"), 1);
        vaca.comer(fabrica.obterSilo("Cevada"), 1);
        System.out.println("Peso após trigo, milho e cevada: " + vaca.getPeso());
    }
}
