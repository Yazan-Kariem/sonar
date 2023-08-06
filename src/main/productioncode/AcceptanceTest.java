package productioncode;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="/Users/yazanmansour/eclipse-workspace/untitled3/src/main/Features",
        plugin = {"summary","html:target/cucumber/report.html"},
        monochrome = true, //readable output on console.
        snippets = SnippetType.CAMELCASE,
        glue = "Sakancom.testcode"
)
public class AcceptanceTest {

}
