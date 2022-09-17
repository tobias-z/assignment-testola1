package io.github.tobiasz.testola1.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class CelsiusToFahrenheitAcceptanceTest {

    private static final String URL = "/convert/celsius-to-fahrenheit";

    @Autowired
    protected MockMvc mvc;

    private Double calculatedFahrenheit;
    private int responseStatus;

    @Given("a person who wants to see the fahrenheit version of celsius")
    public void aPersonWhoWantsToSeeTheFahrenheitVersionOfCelsius() {
        this.calculatedFahrenheit = 0.0;
        this.responseStatus = 0;
    }

    @When("the celsius being converted is {double}")
    public void theCelsiusBeingConvertedIsCelsius(double celsius) throws Exception {
        String response = this.mvc.perform(get(URL).queryParam("celsius", String.valueOf(celsius)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        this.calculatedFahrenheit = Double.parseDouble(response);
    }

    @Then("the found fahrenheit is {double}")
    public void theFoundFahrenheitIsFahrenheit(double fahrenheit) {
        assertThat(this.calculatedFahrenheit).isEqualTo(fahrenheit);
    }

    @When("the celsius is null")
    public void theCelsiusIsNull() throws Exception {
        this.responseStatus = this.mvc.perform(get(URL))
                .andReturn()
                .getResponse()
                .getStatus();
    }

    @Then("the returned response is a status of {int}")
    public void theReturnedResponseIsAStatusOf(int status) {
        assertThat(this.responseStatus).isEqualTo(status);
    }
}
