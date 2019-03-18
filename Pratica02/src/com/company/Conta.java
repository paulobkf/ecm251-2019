package com.company;

public class Conta {

    int numero;
    String titular;
    double saldo;
    String cpf;

    public void visualizarSaldo(){
        System.out.println("Conta: " + numero + "com saldo R$: " + saldo);

    }
    public void depositar(double valorParadepositar){
        saldo += valorParadepositar;

    }

    public void sacar(double valorParaSacar){
        saldo -= valorParaSacar;
    }

    public void tranferirDinheiro(double valor, Conta beneficiado){
        sacar(valor);
        beneficiado.depositar(valor);

    }
}
