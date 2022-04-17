import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


/**
 * This is the Test Runner for Cucumber.
 *
 * @author  Rob Thomson
 * @version 1.0
 * @since   03-03-2021
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles/"},
        tags = "not @ignore",
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json"}
)

public class RunTest {

}
