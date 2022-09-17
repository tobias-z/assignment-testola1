package io.github.tobiasz.testola1.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    public double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

}
