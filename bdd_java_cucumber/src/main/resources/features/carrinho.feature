Feature: Carrinho de Compras

  Scenario: Adicionar um produto ao carrinho
    Given um carrinho vazio
    When eu adiciono o produto "Camiseta" com preço 59.90
    Then o carrinho deve conter "Camiseta"