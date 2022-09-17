package io.github.tobiasz.testola1.cucumberconfig;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
@CucumberContextConfiguration
public class CucumberSpringContextConfig {
}
