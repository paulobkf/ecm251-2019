package com.company;

import java.util.Scanner;

public class ListaDeComprasTestDrive {
    public static void main(String[] args) {
        ListaDeCompras listaDeCompras = new ListaDeCompras();
//        Scanner scanner = new Scanner(System.in);
//        for(int i = 0; i < 3; i++){
//            String nome = scanner.next();
//            if(listaDeCompras.AdicionarProduto(
//                    new Produto(nome)
//            )) {
//                System.out.println("Produto Adicionado");
//            } else {
//                System.out.println("Erro");
//            }
//        }
        listaDeCompras.AdicionarProduto(new Produto("shampoo"));
        listaDeCompras.AdicionarProduto(new Produto("bolacha"));
        if (listaDeCompras.Remover("A"))
            System.out.println("");
    }
}