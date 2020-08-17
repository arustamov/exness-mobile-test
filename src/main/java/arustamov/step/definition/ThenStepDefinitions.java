package arustamov.step.definition;

import arustamov.context.SpringContextAware;
import arustamov.step.ThenSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Shared;

public class ThenStepDefinitions implements SpringContextAware {

    @Shared
    private ThenSteps then;

    @Then("^I should see equity alert turned (ON|OFF)$")
    public void i_should_see_equity_alert_turned(String value) {
        Boolean on = "ON".equals(value);
        then.verifyEquityAlertChecked(on);
    }

    @Then("^I should see news feed updates (ON|OFF)$")
    public void i_should_see_news_feed_updates(String value) {
        Boolean on = "ON".equals(value);
        then.verifyNewsFeedUpdatesChecked(on);
    }
}
