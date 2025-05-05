package com.cucumber.domain;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= valor;
    }
    
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo");
        }
        this.saldo += valor;
    }
    
    public void transferir(ContaBancaria destino, double valor) {
        if (destino == null) {
            throw new IllegalArgumentException("Conta de destino não pode ser nula");
        }
        this.sacar(valor);
        destino.depositar(valor);
    }

    public double getSaldo() {
        return saldo;
    }
} 
