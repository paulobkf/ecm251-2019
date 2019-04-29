package com.company;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTestDrive {
    public static void main(String[] args) {
        List<MinhaClasse> minhaLista;
        minhaLista = new ArrayList<MinhaClasse>();
        MinhaClasse minhaClasse = new MinhaClasse(10,"All Might");
        System.out.println(minhaClasse);
        //Para adicionar objeto a minha lista
        minhaLista.add(minhaClasse);
        minhaLista.add(new MinhaClasse(2,"Endvour"));

        minhaClasse = minhaLista.get(1);
        System.out.println(minhaClasse);

        for(MinhaClasse m : minhaLista){
            System.out.println(m);
        }

    }
}
