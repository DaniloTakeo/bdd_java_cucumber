package com.cucumber.domain.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.cucumber.domain.ContaBancaria;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class DepositoStepDefinitions {

    private ContaBancaria conta;

    @Dado("a conta possui saldo de R$ {double}")
    public void aContaPossuiSaldoDe(double saldoInicial) {
        conta = new ContaBancaria(saldoInicial);
    }
    
    @Quando("for depositado R$ {double}")
    public void forDepositado(Double valor) {
        conta.depositar(valor);
    }

    @Entao("o saldo da conta deve ser R$ {double}")
    public void oSaldoDaContaDeveSer(Double saldoEsperado) {
        assertThat(conta.getSaldo()).isEqualTo(saldoEsperado);
    }
}