package io.github.tobiasz.testola1.acceptence;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
public class FahrenheitToCelsiusAcceptanceTest {

    @Autowired
    private MockMvc mvc;

    private Double calculatedCelsius;

    @Given("an American who wants to see the temperature")
    public void anAmericanWhoWantsToSeeTheTemperature() {
        this.calculatedCelsius = null;
    }

    @When("the fahrenheit is {double}")
    public void theFahrenheitIsFahrenheit(Double fahrenheit) throws Exception {
        String response = mvc.perform(get("/fahrenheit-to-celsius"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        this.calculatedCelsius = Double.parseDouble(response);
    }

    @Then("the celsius is {double}")
    public void theCelsiusIsCelsius(Double expectedCelsius) {
        assertThat(expectedCelsius).isEqualTo(this.calculatedCelsius);
    }
}