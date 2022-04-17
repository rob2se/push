package StepDefinitions;

import actions.CommonActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sikuli.script.FindFailed;
import pageObjects.InteractionTestPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PushStepDef {

    CommonActions actions = new CommonActions();
    InteractionTestPage page = new InteractionTestPage();

    @Given("I am on the the correct url")
    public void iAmOnTheTheCorrectUrl() {
        assertThat(actions.getPageTitle()).isEqualTo("Interaction Test");
    }

    @When("click the button")
    public void clickTheButton() throws FindFailed {
        page.clickButton();
    }

    @Then("the background colour changes")
    public void theBackgroundColourChanges() {
        page.checkBackground();
    }
}
