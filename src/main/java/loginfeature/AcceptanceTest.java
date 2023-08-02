package loginfeature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="/Users/yazanmansour/Downloads/Sakancom/src/main/Features",
        plugin = {"summary","html:target/cucumber/report.html"},
        monochrome = true, //readable output on console.
        snippets = SnippetType.CAMELCASE,
        glue = "Sakancom.loginFeature"
)
public class AcceptanceTest {

}
