Feature: Gestionar elementos

  Background: Entro en el sistema
    Given accedo a la web

  Scenario: Al entrar en la web la lista está vacía
    Then la lista esta vacia

  Scenario: Al introducir un elemento debe quedar añadido a la lista
    When añado el elemento "Ir a dormir" a lista
    Then la lista tiene 1 elemento
    And la lista contiene el elemento "Ir a dormir"

  Scenario: Al introducir dos elementos seguidos la lista va creciendo
    When añado el elemento "Primer elemento" a lista
    And añado el elemento "Segundo elemento" a lista
    Then la lista tiene 2 elemento
    And la lista contiene el elemento "Primer elemento"
    And la lista contiene el elemento "Segundo elemento"
