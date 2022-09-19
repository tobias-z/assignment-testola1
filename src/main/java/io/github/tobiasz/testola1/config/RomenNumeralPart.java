package io.github.tobiasz.testola1.config;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@Builder
public class RomenNumeralPart {
    private final char defaultChar;
    private final char middleChar;
    private final char endChar;

    private final int numberLengthToHandle;

    public void buildNumeralSequence(int firstNumber, StringBuilder romanNumerals) {
        if (firstNumber < 4) {
            for (int i = 0; i < firstNumber; i++) {
                romanNumerals.append(this.defaultChar);
            }
        } else if (firstNumber == 4) {
            romanNumerals.append(this.defaultChar);
            romanNumerals.append(this.middleChar);
        } else if (firstNumber == 5) {
            romanNumerals.append(this.middleChar);
        } else if (firstNumber == 9) {
            romanNumerals.append(this.defaultChar);
            romanNumerals.append(this.endChar);
        } else {
            firstNumber = firstNumber - 5;
            romanNumerals.append(this.middleChar);
            for (int i = 0; i < firstNumber; i++) {
                romanNumerals.append(this.defaultChar);
            }
        }
    }

    public boolean canHandleLength(int length) {
        return this.numberLengthToHandle == length;
    }
}
