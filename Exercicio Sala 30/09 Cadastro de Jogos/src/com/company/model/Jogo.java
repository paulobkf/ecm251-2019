package com.company.model;

public class Jogo {
    public String nome, genero, plataforma, lancamento;
    private int id;

    public Jogo(){
        id = -1;
    }

    public Jogo(int id){
        this.id = id;
    }

    public Jogo(String nome, String genero,String plataforma, String lancamento){
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.lancamento = lancamento;
    }

    public int getId(){
        return id;
    }

}
