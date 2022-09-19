package io.github.tobiasz.testola1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ArabicToRomanConverterServiceTest {

    @Autowired
    private ConverterService converterService;

    @Test
    @DisplayName("can convert 10 to X")
    void canConvert10ToX() throws Exception {
        String romanNumeral = this.converterService.convertToRomanNumeral(10);
        assertThat(romanNumeral).isEqualTo("X");
    }

    @Test
    @DisplayName("will throw given a number which is too big")
    void willThrowGivenANumberWhichIsTooBig() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> this.converterService.convertToRomanNumeral(4_000_000));
    }

    @Test
    @DisplayName("will throw given a number under 1")
    void willThrowGivenANumberUnder1() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> this.converterService.convertToRomanNumeral(0));
    }

    @Test
    @DisplayName("can convert numbers above 1000 by adding an underscore in front")
    void canConvertNumbersAbove1000ByAddingAnUnderscoreInFront() throws Exception {
        String romanNumeral = this.converterService.convertToRomanNumeral(10000);
        assertThat(romanNumeral).isEqualTo("_X");
    }

}