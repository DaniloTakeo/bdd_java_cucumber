Feature: Histórico de transações
  Como um cliente do banco
  Quero ver o histórico correto após uma transferência
  Para acompanhar minhas movimentações

  Scenario: Registro de histórico após transferência entre contas
    Given a conta de origem possui saldo de R$ 1000
    And a conta de destino possui saldo de R$ 500
    When eu transfiro R$ 200 da conta de origem para a conta de destino
    Then o histórico da conta de origem deve conter uma transação de saída de R$ 200
    And o histórico da conta de destino deve conter uma transação de entrada de R$ 200