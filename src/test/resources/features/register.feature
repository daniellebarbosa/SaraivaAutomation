Feature: register new individual on Saraiva website

  Scenario: register new individual on Saraiva website successfully
    Given user is on Home Page
    When he clicks to register on the site
    And choose the correct option for register
    And he clicks on Cadastrar
    And enter the required data
    Then user is registered

  Scenario: register new individual on Saraiva website with invalid CPF
    Given user is on Home Page
    When he clicks to register on the site
    And choose the correct option for register
    And he clicks on Cadastrar
    And enter the required data with an existing email
    Then then the error message is displayed
