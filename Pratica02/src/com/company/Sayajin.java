package com.company;

public class Sayajin {
    String nome;
    double ki;
    boolean odio;
    int niveldeSuper;

    public void treinar(){
        if (odio)
            ki *= 1.2;
        else
            ki = ki*1.1;
        System.out.println("Depois do treino o poder de luta é: " +ki);
    }

    public String pegarCordoCabelo(){
        String resultado;
        if(niveldeSuper == 0)
            resultado = "Preto";
        else if(niveldeSuper > 0 && niveldeSuper <= 3)
            resultado = "Amarelo";
        else
            resultado = "Azul";
        return resultado;

    }

}
