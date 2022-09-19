package io.github.tobiasz.testola1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RomenNumeralPartConfig {

    @Bean
    public RomenNumeralPart digitsBuilder() {
        return RomenNumeralPart.builder()
                .defaultChar('I')
                .middleChar('V')
                .endChar('X')
                .numberLengthToHandle(1)
                .build();
    }

    @Bean
    public RomenNumeralPart tensBuilder() {
        return RomenNumeralPart.builder()
                .defaultChar('X')
                .middleChar('L')
                .endChar('C')
                .numberLengthToHandle(2)
                .build();
    }

    @Bean
    public RomenNumeralPart hundredsBuilder() {
        return RomenNumeralPart.builder()
                .defaultChar('C')
                .middleChar('D')
                .endChar('M')
                .numberLengthToHandle(3)
                .build();
    }
}
