package io.github.tobiasz.testola1.service;

import io.github.tobiasz.testola1.config.RomenNumeralPart;
import io.github.tobiasz.testola1.factory.RomenNumeralPartFactory;
import java.util.Arrays;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConverterService {

    private final RomenNumeralPartFactory romenNumeralPartFactory;

    public double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    public double convertToFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    public String convertToRomanNumeral(int arabicNumeral) {
        if (arabicNumeral <= 0) {
            throw new IllegalArgumentException("Numbers under or equal to 0 cannot be converted to a roman numeral");
        }
        if (arabicNumeral > 3_999_999) {
            throw new IllegalArgumentException("Unable to convert numbers starting from 4_000_000");
        }
        char[] numbers = Integer.toString(arabicNumeral).toCharArray();
        StringBuilder romanNumerals = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int highestNumber = Character.getNumericValue(numbers[i]);
            int numberLength = numbers.length - i;
            this.addRomanNumeral(highestNumber, numberLength, romanNumerals);
        }
        return romanNumerals.toString();
    }

    private void addRomanNumeral(int firstNumber, int numberLength, StringBuilder romanNumerals) {
        if (firstNumber == 0) {
            return;
        }
        // If we are above 4 digits ex: 10000 we want to use the same logic but put a '_' in front of the generated sequence
        if (numberLength > 4) {
            numberLength = numberLength - 3;
            romanNumerals.append('_');
        }

        Optional<RomenNumeralPart> romenNumeralPart = this.romenNumeralPartFactory.getRomenNumeralPart(numberLength);

        if (romenNumeralPart.isPresent()) {
            romenNumeralPart.get().buildNumeralSequence(firstNumber, romanNumerals);
        } else {
            for (int i = 0; i < firstNumber; i++) {
                romanNumerals.append('M');
            }
        }
    }
}
