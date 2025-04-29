package com.desafiobancodio.banco;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, String pwd) {
        super(cliente, pwd);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}
