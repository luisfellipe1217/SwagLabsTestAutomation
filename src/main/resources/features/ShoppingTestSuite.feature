Feature: Validar compras utilizando o SwagLabs

  Background:
    Given Teste: 'Validar Login site SwagLabs'
    Given Que eu esteja usando o navegador 'CHROME'
    And Eu acesso o site SwagLabs
    When Eu insiro o UserName: "standard_user"
    And Eu insiro o PassWord: "secret_sauce"
    And clico no botão Login

  @Test
  Scenario: Validar Login SwagLabs
    Given Teste: 'Validar produto adicionado ao Carrinho'
    Given Eu estou na pagina de produtos
    When Eu acho algum produto
    And clico no botão Add to cart
    And quando eu clico no botão do carrinho
    Then devo ser capaz de visualizar o mesmo produto no carrinho para finalização da compra
