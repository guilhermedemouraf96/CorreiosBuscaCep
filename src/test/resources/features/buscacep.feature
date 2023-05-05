#Author: your.email@your.domain.com

@buscaCEP
Feature: Buscar CEP
Como usuario
Quero pesquisar um CEP
Para visualizar endereço correspondente ao CEP pesquisado
  
Background: 
Given que esteja na pagina inicial

  @positivo
  Scenario: Buscar um CEP válido
    When pesquisar um CEP válido
    Then validar o endereço 
  @negativo
   Scenario: Buscar um CEP em branco
    But pesquisar um CEP em branco
    Then visualizo mensagem de erro
