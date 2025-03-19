Feature: Validar Login site SwagLabs

  @Test
  Scenario: Validar Login SwagLabs
    Given Teste: 'Validar Login site SwagLabs'
    Given Que eu esteja usando o navegador 'CHROME'
    And Eu acesso o site SwagLabs
    When Eu insiro o UserName: "standard_user"
    And Eu insiro o PassWord: "secret_sauce"
    And clico no botão Login
    Then Eu sou capaz de visualizar a Página inicial com uma lista de produtos.