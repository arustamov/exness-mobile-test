package arustamov.screen.container;

import arustamov.screen.MobilePageObject;
import org.openqa.selenium.By;

public class AppGuidePopup extends MobilePageObject {

    private static final String CONTAINER_ID = "card_root";
    private static final String TITLE_ID = "message_title";
    private static final String WATCH_NOW_ID = "primary_button";
    private static final String LATER_ID = "secondary_button";

    public Boolean isDisplayed() {
        return containsElements(
            By.id(CONTAINER_ID)
        );
    }

    public String getTitle() {
        return find(
            By.id(TITLE_ID)
        )
            .getText();
    }

    public void tapWatchNow() {
        find(
            By.id(WATCH_NOW_ID)
        )
            .click();
    }

    public void tapLater() {
        find(
            By.id(LATER_ID)
        )
            .click();
    }
}
