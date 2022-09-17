Feature: Fahrenheit To Celsius

  Scenario Outline: Can transform fahrenheit into celsius
    Given a person who wants to see the celsius version of fahrenheit
    When the fahrenheit is <fahrenheit>
    Then the celsius is <celsius>

    Examples:
      | fahrenheit | celsius |
      | 86         | 30      |
      | 50         | 10      |

  Scenario: Can handle invalid fahrenheit values
    Given a person who wants to see the celsius version of fahrenheit
    When the fahrenheit is null
    Then the response is a status of 400