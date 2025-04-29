package com.desafiobancodio.banco;

import java.util.Scanner;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private String password;

    public Conta(Cliente cliente, String password) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.password = password;
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean checkPassword() {
        System.out.println("Por seguranca, informe sua senha");
        String confirmPwd = scanner.next();
        return confirmPwd.equals(this.password);
    }

    @Override
    public void sacar(double valor) {

        if(this.checkPassword()){
        saldo -= valor;
            System.out.println("Saque realizado!");
        } else {
            System.out.println("Senha incoreta, requisicao cancelada.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (this.checkPassword()) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferencia realizada!");
        } else {
            System.out.println("Senha incoreta, requisicao cancelada.");
        }
    }

    public void changePassword(String newPwd) {
        if (this.checkPassword()) {
            this.password = newPwd;
            System.out.println("Senha alterada!");
        } else {
            System.out.println("Senha incoreta, requisicao cancelada.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        if (this.checkPassword()) {
            return saldo;
        } else {
            throw new RuntimeException("Senha incorreta, requisicao cancelada");
        }
    }

    protected void imprimirInfosComuns() {
        if (this.checkPassword()) {
            System.out.printf("Titular: %s%n", this.cliente.getNome());
            System.out.printf("Email: %s%n", this.cliente.getEmail());
            System.out.printf("Agencia: %d%n", this.agencia);
            System.out.printf("Numero: %d%n", this.numero);
            System.out.printf("Saldo: %.2f%n", this.saldo);
        } else {
            System.out.println("Senha incorreta, requisicao cancelada");
        }
    }
}
