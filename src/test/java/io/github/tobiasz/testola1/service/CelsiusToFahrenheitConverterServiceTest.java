package io.github.tobiasz.testola1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CelsiusToFahrenheitConverterServiceTest {

    @Autowired
    private ConverterService converterService;

    @Test
    @DisplayName("can convert fahrenheit to celsius")
    void canConvertFahrenheitToCelsius() throws Exception {
        double fahrenheit = this.converterService.convertToFahrenheit(30);
        assertThat(fahrenheit).isEqualTo(86);
    }

}