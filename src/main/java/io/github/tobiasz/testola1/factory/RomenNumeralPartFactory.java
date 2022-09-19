package io.github.tobiasz.testola1.factory;

import io.github.tobiasz.testola1.config.RomenNumeralPart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RomenNumeralPartFactory {

    private final List<RomenNumeralPart> romenNumeralParts;

    public Optional<RomenNumeralPart> getRomenNumeralPart(int lengthToHandle) {
        return this.romenNumeralParts.stream()
                .filter(romenNumeralPart -> romenNumeralPart.canHandleLength(lengthToHandle))
                .findFirst();
    }
}
