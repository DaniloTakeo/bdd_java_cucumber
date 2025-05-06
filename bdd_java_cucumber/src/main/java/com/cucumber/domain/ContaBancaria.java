package com.cucumber.domain;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private double saldo;
    private List<Transacao> historico = new ArrayList<>();

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo");
        }
        this.saldo += valor;
        historico.add(new Transacao(TipoTransacao.DEPOSITO, valor));
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        this.saldo -= valor;
        historico.add(new Transacao(TipoTransacao.SAQUE, valor));
    }
    
    public void transferir(ContaBancaria destino, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        this.saldo -= valor;
        destino.saldo += valor;

        this.historico.add(new Transacao(TipoTransacao.TRANSFERENCIA_SAIDA, valor));
        destino.historico.add(new Transacao(TipoTransacao.TRANSFERENCIA_ENTRADA, valor));
    }
    
    public List<Transacao> getHistorico() {
        return historico;
    }

    public double getSaldo() {
        return saldo;
    }
} 
