package com.cucumber.domain.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.cucumber.domain.ContaBancaria;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class SaqueSteps {
    private ContaBancaria conta;

    @Dado("que a conta possui saldo de {double} reais")
    public void que_a_conta_possui_saldo_de_reais(Double saldo) {
        conta = new ContaBancaria(saldo);
    }

    @Quando("o cliente realiza um saque de {double} reais")
    public void o_cliente_realiza_um_saque_de_reais(Double valor) {
        conta.sacar(valor);
    }

    @Entao("o novo saldo da conta deve ser {double} reais")
    public void o_novo_saldo_da_conta_deve_ser_reais(Double saldoEsperado) {
        assertThat(conta.getSaldo()).isEqualTo(saldoEsperado);
    }
}
