package io.github.tobiasz.testola1.acceptance.cucumberconfig;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "io.github.tobiasz.testola1.acceptance," +
                "io.github.tobiasz.testola1.acceptance.cucumberconfig"
)
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
public class CucumberAcceptanceTest {
}
