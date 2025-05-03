Feature: Depósito em conta bancária

  Scenario: Cliente realiza um depósito com sucesso
    Given a conta possui saldo de R$ 0
    When for depositado R$ 100
    Then o saldo da conta deve ser R$ 100