package io.github.tobiasz.testola1.acceptence;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

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
    private int responseStatus;

    @Given("an American who wants to see the temperature")
    public void anAmericanWhoWantsToSeeTheTemperature() {
        this.calculatedCelsius = null;
    }

    @When("the fahrenheit is {double}")
    public void theFahrenheitIsFahrenheit(Double fahrenheit) throws Exception {
        MockHttpServletRequestBuilder request = get("/convert/fahrenheit-to-celsius")
                .queryParam("fahrenheit", String.valueOf(fahrenheit));

        String response = mvc.perform(request)
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
        this.responseStatus = mvc.perform(get("/convert/fahrenheit-to-celsius"))
                .andReturn()
                .getResponse()
                .getStatus();
    }

    @Then("the response is a status of {int}")
    public void theResponseIsAStatusOf(int status) {
        assertThat(this.responseStatus).isEqualTo(status);
    }
}
