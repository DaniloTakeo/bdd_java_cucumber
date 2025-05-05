package com.cucumber.domain.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.cucumber.domain.ContaBancaria;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class TransferenciaStepDefinitions {

    private ContaBancaria contaOrigem;
    private ContaBancaria contaDestino;
    private Throwable excecao;

    @Dado("a conta de origem possui saldo de R$ {double}")
    public void aContaDeOrigemPossuiSaldoDe(double saldo) {
        contaOrigem = new ContaBancaria(saldo);
    }

    @Dado("a conta de destino possui saldo de R$ {double}")
    public void aContaDeDestinoPossuiSaldoDe(double saldo) {
        contaDestino = new ContaBancaria(saldo);
    }
    
    @Quando("eu transfiro R$ {double} da conta de origem para a conta de destino")
    public void euTransfiroDaContaDeOrigemParaADestino(double valor) {
        contaOrigem.transferir(contaDestino, valor);
    }
    
    @Quando("eu tento transferir R$ {double} da conta de origem para a conta de destino")
    public void euTentoTransferirDaContaDeOrigemParaADestino(double valor) {
        try {
            contaOrigem.transferir(contaDestino, valor);
        } catch (Throwable t) {
            this.excecao = t;
        }
    }
    
    @Então("o saldo da conta de origem deve ser R$ {double}")
    public void oSaldoDaContaDeOrigemDeveSer(double esperado) {
        assertThat(contaOrigem.getSaldo()).isEqualTo(esperado);
    }
    
    @Então("o saldo da conta de destino deve ser R$ {double}")
    public void oSaldoDaContaDeDestinoDeveSer(double esperado) {
        assertThat(contaDestino.getSaldo()).isEqualTo(esperado);
    }
    
    @Então("uma exceção deve ser lançada com a mensagem {string}")
    public void umaExcecaoDeveSerLancadaComAMensagem(String mensagem) {
        assertThat(excecao)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage(mensagem);
    }
}