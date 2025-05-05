Feature: Transferência entre contas
  Como um cliente do banco
  Quero transferir dinheiro de uma conta para outra
  Para realizar pagamentos ou enviar dinheiro a terceiros

  Scenario: Transferência com saldo suficiente
    Given a conta de origem possui saldo de R$ 1000.0
    And a conta de destino possui saldo de R$ 500.0
    When eu transfiro R$ 200.0 da conta de origem para a conta de destino
    Then o saldo da conta de origem deve ser R$ 800.0
    And o saldo da conta de destino deve ser R$ 700.0
    
  Scenario: Transferência com saldo insuficiente
    Given a conta de origem possui saldo de R$ 100.0
    And a conta de destino possui saldo de R$ 100.0
    When eu tento transferir R$ 200.0 da conta de origem para a conta de destino
    Then uma exceção deve ser lançada com a mensagem "Saldo insuficiente"