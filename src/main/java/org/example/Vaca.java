package org.example;

import java.util.HashMap;
import java.util.Map;

public class Vaca {
    private int peso;
    public int getPeso(){
        return  peso;
    }
    public void ComerTrigo(int quantidade){
        Fazenda fazenda = new Fazenda(quantidade);
        this.peso += fazenda.alimentar(new SiloTrigo());
    }
    public void ComerMilho(int quantidade){
        Fazenda fazenda = new Fazenda(quantidade);
        this.peso += fazenda.alimentar(new SiloMilho());

    }

    public void ComerCevada(int quantidade){
        Fazenda fazenda = new Fazenda(quantidade);
        this.peso += fazenda.alimentar(new SiloCevada());

    }
}
