package com.company;

public class Produto {
    private String nome;
    public Produto(String nome){
        this.nome = nome;
    }
    @Override
    public String toString() {
        return nome;
    }

    public boolean equals(Produto obj){
        return this.nome.equals(obj.toString());
    }
}
