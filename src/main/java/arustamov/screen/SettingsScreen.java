package arustamov.screen;

import org.openqa.selenium.By;

public class SettingsScreen extends MobilePageObject {

    private static final String EQUITY_ALERT_ID = "pushAlertsSwitch";
    private static final String NEWS_FEED_UPDATES_ID = "pushFeedSwitch";

    public void tapEquityAlert() {
        find(
            By.id(EQUITY_ALERT_ID)
        )
            .click();
    }

    public Boolean isEquityAlertChecked() {
        return find(
            By.id(EQUITY_ALERT_ID)
        )
            .getAttribute("checked")
            .equals("true");
    }

    public void tapNewsFeedUpdates() {
        find(
            By.id(NEWS_FEED_UPDATES_ID)
        )
            .click();
    }

    public Boolean isNewsFeedUpdatesChecked() {
        return find(
            By.id(NEWS_FEED_UPDATES_ID)
        )
            .getAttribute("checked")
            .equals("true");
    }
}
