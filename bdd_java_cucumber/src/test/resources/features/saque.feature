Feature: Saque de dinheiro

  Scenario: Cliente com saldo suficiente realiza saque com sucesso
    Given que a conta possui saldo de 500 reais
    When o cliente realiza um saque de 200 reais
    Then o novo saldo da conta deve ser 300 reais
