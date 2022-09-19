package io.github.tobiasz.testola1.controller;

import io.github.tobiasz.testola1.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/convert")
@RequiredArgsConstructor
public class ConverterController {

    private final ConverterService converterService;

    @GetMapping("/fahrenheit-to-celsius")
    public Double fahrenheitToCelsius(@RequestParam("fahrenheit") @NotNull Double fahrenheit) {
        return this.converterService.convertToCelsius(fahrenheit);
    }

    @GetMapping("/celsius-to-fahrenheit")
    public Double celsiusToFahrenheit(@RequestParam("celsius") @NotNull Double celsius) {
        return this.converterService.convertToFahrenheit(celsius);
    }

    @GetMapping("/arabic-to-roman")
    public String arabicToRoman(@RequestParam("arabic") @NotNull Integer arabic) {
        return this.converterService.convertToRomanNumeral(arabic);
    }
}
