package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, features = "src/test/resources/features", glue = {"steps", "helper"},
                                plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"})
public class TestRunner {
}