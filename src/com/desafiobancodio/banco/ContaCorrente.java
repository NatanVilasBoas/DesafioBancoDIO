package com.desafiobancodio.banco;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, String pwd) {
        super(cliente, pwd);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

}
