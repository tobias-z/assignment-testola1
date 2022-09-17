package io.github.tobiasz.testola1.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FahrenheitToCelsiusAcceptanceTest {

    private static final String URL = "/convert/fahrenheit-to-celsius";

    @Autowired
    protected MockMvc mvc;

    private Double calculatedCelsius;
    private int responseStatus;

    @Given("a person who wants to see the celsius version of fahrenheit")
    public void aPersonWhoWantsToSeeTheCelsiusVersionOfFahrenheit() {
        this.calculatedCelsius = null;
        this.responseStatus = 0;
    }

    @When("the fahrenheit is {double}")
    public void theFahrenheitIsFahrenheit(Double fahrenheit) throws Exception {

        String response = mvc.perform(get(URL).queryParam("fahrenheit", String.valueOf(fahrenheit)))
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

    @When("the fahrenheit is null")
    public void theFahrenheitIsNull() throws Exception {
        this.responseStatus = mvc.perform(get(URL))
                .andReturn()
                .getResponse()
                .getStatus();
    }

    @Then("the response is a status of {int}")
    public void theResponseIsAStatusOf(int status) {
        assertThat(this.responseStatus).isEqualTo(status);
    }

}
