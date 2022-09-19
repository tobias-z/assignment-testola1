Feature: Arabic numeral to Roman numeral

  Scenario Outline: Can convert Arabic numerals to Roman numerals
    Given a converter from arabic numerals to roman numerals
    When i convert the arabic number <arabicNumeral> to a roman numeral
    Then the roman numeral is "<romanNumeral>"

    Examples:
      | arabicNumeral | romanNumeral |
      | 1             | I            |
      | 2             | II           |
      | 3             | III          |
      | 4             | IV           |
      | 5             | V            |
      | 6             | VI           |
      | 7             | VII          |
      | 8             | VIII         |
      | 9             | IX           |
      | 10            | X            |
      | 1000          | M            |
      | 10114         | _XCXIV       |
