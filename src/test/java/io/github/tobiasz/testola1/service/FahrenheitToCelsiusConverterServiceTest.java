package io.github.tobiasz.testola1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FahrenheitToCelsiusConverterServiceTest {

    @Autowired
    private ConverterService converterService;

    @Test
    @DisplayName("can convert fahrenheit to celsius")
    void canConvertFahrenheitToCelsius() throws Exception {
        double celsius = this.converterService.convertToCelsius(86);
        assertThat(celsius).isEqualTo(30);
    }

    @Test
    @DisplayName("can handle negative numbers")
    void canHandleNegativeNumbers() throws Exception {
        double celsius = this.converterService.convertToCelsius(-85);
        assertThat(celsius).isEqualTo(-65);
    }
}