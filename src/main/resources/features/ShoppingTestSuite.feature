Feature: Validar compras utilizando o SwagLabs

  Background:
    Given Teste: 'Realizar Login site SwagLabs'
    Given Que eu esteja usando o navegador 'CHROME'
    And Eu acesso o site SwagLabs
    When Eu insiro o UserName: "standard_user"
    And Eu insiro o PassWord: "secret_sauce"
    And clico no botão Login

  @Test1
  Scenario: Validar Funcionalidade 'Add to Cart' SwagLabs
    Given Teste: 'Validar produto adicionado ao Carrinho'
    Given Eu estou na pagina de produtos
    When Eu acho algum produto
    And clico no botão Add to cart
    And quando eu clico no botão do carrinho
    Then devo ser capaz de visualizar o mesmo produto no carrinho para finalização da compra

  @Test2
  Scenario: Validar Finalização de compra no SwagLabs
    Given Teste: 'Validar finalização de compra'
    Given Eu estou na pagina de produtos
    When Eu acho algum produto
    And clico no botão Add to cart
    And quando eu clico no botão do carrinho
    And devo ser capaz de visualizar o mesmo produto no carrinho para finalização da compra
    And clico no botão Checkout
    And preencho a informação de first name 'Luis'
    And preencho a informação de Last Name 'Test'
    And preencho a informação Zip-Code'13080000'
    And clico no botão Continue
    And sou capaz de visualizar o Checkout Overview com todas as informações da minha compra
    And clico em Finish
    Then Sou capaz de visualizar a mensagem de finalização de compra.
