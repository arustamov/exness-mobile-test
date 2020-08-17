package arustamov.step;

import arustamov.context.SpringContextAware;
import arustamov.screen.SettingsScreen;
import arustamov.screen.container.AppGuidePopup;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class ThenSteps implements SpringContextAware {

    private AppGuidePopup appGuidePopup;
    private SettingsScreen settingsScreen;

    public Boolean verifyAppGuideDisplayed() {
        Boolean displayed = appGuidePopup.isDisplayed();
        Assertions.assertThat(displayed)
            .as("App guide displayed")
            .isNotNull();
        return displayed;
    }

    @Step
    public Boolean verifyEquityAlertChecked() {
        Boolean checked = settingsScreen.isEquityAlertChecked();
        Assertions.assertThat(checked)
            .as("Equity alert checked")
            .isNotNull();
        return checked;
    }

    @Step
    public void verifyEquityAlertChecked(final Boolean on) {
        Assertions.assertThat(
            settingsScreen.isEquityAlertChecked()
        )
            .as("Equity alert checked")
            .isEqualTo(on);
    }

    @Step
    public Boolean verifyNewsFeedUpdatesChecked() {
        Boolean checked = settingsScreen.isNewsFeedUpdatesChecked();
        Assertions.assertThat(checked)
            .as("News feed updates checked")
            .isNotNull();
        return checked;
    }

    @Step
    public void verifyNewsFeedUpdatesChecked(final Boolean on) {
        Assertions.assertThat(
            settingsScreen.isNewsFeedUpdatesChecked()
        )
            .as("News feed updates checked")
            .isEqualTo(on);
    }
}
