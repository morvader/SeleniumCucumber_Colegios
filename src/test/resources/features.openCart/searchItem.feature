Feature: Buscar elementos en la pagina principal

  Background:
    Given Estoy en la pagina principal

  Scenario Outline: Cuando busco un elemento debe mostrarse en la pagina de resultados con su precio correcto
    When busco el elemento "<item>"
    Then el elemento "<item>" aparece en la pagina de resultado con el precio "<precio>"
    Examples:
      | item        | precio    |
      | iPhone      | $123.20   |
      | MacBook Pro | $2,000.00 |

