package io.github.tobiasz.testola1.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.tobiasz.testola1.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class ArabicToRomanAcceptanceTest {

    @Autowired
    private MockMvc mvc;
    private String convertedRomanNumeral;

    @Given("a converter from arabic numerals to roman numerals")
    public void theArabicNumberIsArabicNumeral() {
    }

    @When("i convert the arabic number {int} to a roman numeral")
    public void iConvertItToARomanNumber(int arabicNumeral) throws Exception {
        this.convertedRomanNumeral = this.mvc.perform(get("/convert/arabic-to-roman").queryParam("arabic", String.valueOf(arabicNumeral)))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Then("the roman numeral is {string}")
    public void theRomanNumberIsRomanNumeral(String romanNumeral) {
        assertThat(this.convertedRomanNumeral).isEqualTo(romanNumeral);
    }
}
