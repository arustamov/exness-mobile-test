package arustamov.step.definition;

import arustamov.context.SpringContextAware;
import arustamov.entity.User;
import arustamov.enums.SessionVariable;
import arustamov.step.ThenSteps;
import arustamov.step.WhenSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Shared;

public class WhenStepDefinitions implements SpringContextAware {

    @Shared
    private WhenSteps when;
    @Shared
    private ThenSteps then;

    @When("^I open the application$")
    public void i_open_the_application() {
        when.openApplication();
        when.waitForScreenTransition();
    }

    @When("^I go back$")
    public void i_go_back() {
        when.goBack();
        when.waitForScreenTransition();
    }

    @When("^I dismiss app guide$")
    public void i_dismiss_app_guide() {
        final Boolean displayed = then.verifyAppGuideDisplayed();
        if (displayed) {
            when.dismissAppGuideIfDisplayed();
            when.waitForScreenTransition();
        }
    }

    @When("^I go to sign in$")
    public void i_go_to_sign_in() {
        when.goToSignIn();
    }

    @When("^I sign in$")
    public void i_sign_in() {
        User user = Serenity.sessionVariableCalled(SessionVariable.USER);

        when.provideEmailForSignIn(
            user.getEmail()
        );
        when.providePasswordForSignIn(
            user.getPassword()
        );
        when.trySignIn();
        when.waitForProgressBarDisplayed(false);
        when.waitForScreenTransition();
    }

    @And("^I sign out$")
    public void i_sign_out() {
        when.trySignOut();
        when.confirmDialog();
        when.waitForScreenTransition();
    }

    @When("^I skip set a passcode$")
    public void i_skip_set_a_passcode() {
        when.skipSetPassCode();
        when.waitForScreenTransition();
    }

    @When("^I close crypto introduction$")
    public void i_close_crypto_introduction() {
        when.closeCryptoIntroduction();
        when.waitForScreenTransition();
    }

    @When("^I skip onboarding$")
    public void i_skip_onboarding() {
        when.skipOnboarding();
        when.waitForScreenTransition();
    }

    @When("^I go to wallet$")
    public void i_go_to_wallet() {
        when.goToWallet();
        when.waitForScreenTransition();
    }

    @And("^I go to profile$")
    public void i_go_to_profile() {
        when.goToProfile();
        when.waitForScreenTransition();
    }

    @When("^I go to settings$")
    public void i_go_to_settings() {
        when.goToSettings();
        when.waitForScreenTransition();
    }

    @When("^I try to turn equity alert OFF$")
    public void i_try_to_turn_equity_alert_off() {
        when.trySwitchEquityAlert();
        when.waitForScreenTransition();
    }

    @When("^I confirm turn equity alert OFF$")
    public void i_confirm_turn_equity_alert_off() {
        when.confirmDialog();
        when.waitForScreenTransition();
    }

    @When("^I cancel turn equity alert OFF$")
    public void i_cancel_turn_equity_alert_off() {
        when.cancelDialog();
        when.waitForScreenTransition();
    }

    @When("^I turn equity alert (ON|OFF)$")
    public void i_turn_equity_alert(String value) {
        Boolean on = "ON".equals(value);
        final Boolean checked = then.verifyEquityAlertChecked();
        if (!checked.equals(on)) {
            when.trySwitchEquityAlert();
            if (!on) {
                when.confirmDialog();
            }
            when.waitForScreenTransition();
        }
    }

    @When("^I turn news feed updates (ON|OFF)$")
    public void i_turn_news_feed_updates(String value) {
        Boolean on = "ON".equals(value);
        final Boolean checked = then.verifyNewsFeedUpdatesChecked();
        if (!checked.equals(on)) {
            when.switchNewsFeedUpdates();
            when.waitForScreenTransition();
        }
    }
}
