package com.cucumber.domain.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.cucumber.domain.ContaBancaria;
import com.cucumber.domain.ScenarioContext;
import com.cucumber.domain.TipoTransacao;
import com.cucumber.domain.Transacao;

import io.cucumber.java.pt.Entao;

public class HistoricoStepDefinitions {

    private final ScenarioContext scenarioContext;

    public HistoricoStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Entao("o histórico da conta de origem deve conter uma transação de saída de R$ {double}")
    public void historicoDaContaOrigemDeveConterSaida(double valor) {
        ContaBancaria contaOrigem = scenarioContext.getContaOrigem();
        List<Transacao> historico = contaOrigem.getHistorico();
        assertThat(historico)
            .anySatisfy(transacao -> {
                assertThat(transacao.getTipo()).isEqualTo(TipoTransacao.TRANSFERENCIA_SAIDA);
                assertThat(transacao.getValor()).isEqualTo(valor);
            });
    }

    @Entao("o histórico da conta de destino deve conter uma transação de entrada de R$ {double}")
    public void historicoDaContaDestinoDeveConterEntrada(double valor) {
        ContaBancaria contaDestino = scenarioContext.getContaDestino();
        List<Transacao> historico = contaDestino.getHistorico();
        assertThat(historico)
            .anySatisfy(transacao -> {
                assertThat(transacao.getTipo()).isEqualTo(TipoTransacao.TRANSFERENCIA_ENTRADA);
                assertThat(transacao.getValor()).isEqualTo(valor);
            });
    }
}