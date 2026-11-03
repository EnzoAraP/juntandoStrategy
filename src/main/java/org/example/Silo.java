package org.example;

public abstract class Silo {
    // Template Method: mantém a validação e o cálculo comuns aos silos.
    public final int alimentar(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa");
        }
        return quantidade * getGanhoPorUnidade();
    }

    protected abstract int getGanhoPorUnidade();
}
