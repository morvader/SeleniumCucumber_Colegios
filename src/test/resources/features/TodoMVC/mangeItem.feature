Feature: Gestionar elementos

  Scenario: Al introducir un elemento debe quedar añadido a la lista
    Given accedo a la web
    When añado el elemento "Ir a dormir" a lista
    Then la lista tiene 1 elemento
    And la lista contiene el elemento "Ir a dormir"