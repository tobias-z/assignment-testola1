Feature: Celsius To Fahrenheit

  Scenario Outline: Can transform celsius into fahrenheit
    Given a person who wants to see the fahrenheit version of celsius
    When the celsius being converted is <celsius>
    Then the found fahrenheit is <fahrenheit>

    Examples:
      | fahrenheit | celsius |
      | 86         | 30      |
      | 50         | 10      |

  Scenario: Can handle invalid celsius values
    Given a person who wants to see the fahrenheit version of celsius
    When the celsius is null
    Then the returned response is a status of 400