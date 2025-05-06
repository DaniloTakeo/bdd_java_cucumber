package com.cucumber.domain.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.cucumber.domain.ContaBancaria;
import com.cucumber.domain.ScenarioContext;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class TransferenciaStepDefinitions {

    private final ScenarioContext scenarioContext;
    private Throwable excecao;

    public TransferenciaStepDefinitions(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Dado("a conta de origem possui saldo de R$ {double}")
    public void aContaDeOrigemPossuiSaldoDe(double saldo) {
        ContaBancaria contaOrigem = new ContaBancaria(saldo);
        scenarioContext.setContaOrigem(contaOrigem);
    }

    @Dado("a conta de destino possui saldo de R$ {double}")
    public void aContaDeDestinoPossuiSaldoDe(double saldo) {
        ContaBancaria contaDestino = new ContaBancaria(saldo);
        scenarioContext.setContaDestino(contaDestino);
    }

    @Quando("eu transfiro R$ {double} da conta de origem para a conta de destino")
    public void euTransfiroDaContaDeOrigemParaADestino(double valor) {
        ContaBancaria contaOrigem = scenarioContext.getContaOrigem();
        ContaBancaria contaDestino = scenarioContext.getContaDestino();
        contaOrigem.transferir(contaDestino, valor);
    }

    @Quando("eu tento transferir R$ {double} da conta de origem para a conta de destino")
    public void euTentoTransferirDaContaDeOrigemParaADestino(double valor) {
        ContaBancaria contaOrigem = scenarioContext.getContaOrigem();
        ContaBancaria contaDestino = scenarioContext.getContaDestino();
        try {
            contaOrigem.transferir(contaDestino, valor);
        } catch (Throwable t) {
            this.excecao = t;
        }
    }

    @Entao("o saldo da conta de origem deve ser R$ {double}")
    public void oSaldoDaContaDeOrigemDeveSer(double esperado) {
        assertThat(scenarioContext.getContaOrigem().getSaldo()).isEqualTo(esperado);
    }

    @Entao("o saldo da conta de destino deve ser R$ {double}")
    public void oSaldoDaContaDeDestinoDeveSer(double esperado) {
        assertThat(scenarioContext.getContaDestino().getSaldo()).isEqualTo(esperado);
    }

    @Entao("uma exceção deve ser lançada com a mensagem {string}")
    public void umaExcecaoDeveSerLancadaComAMensagem(String mensagem) {
        assertThat(excecao)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(mensagem);
    }
}