package arustamov.screen.container;

import arustamov.screen.MobilePageObject;
import org.openqa.selenium.By;

public class Toolbar extends MobilePageObject {

    private static final String SKIP_ID = "btnSkip";
    private static final String SETTINGS_ID = "ivSettings";
    private static final String PROFILE_ID = "btnProfile";

    public void tapSkip() {
        find(
            By.id(SKIP_ID)
        )
            .click();
    }

    public void tapProfile() {
        find(
            By.id(PROFILE_ID)
        )
            .click();
    }

    public void tapSettings() {
        find(
            By.id(SETTINGS_ID)
        )
            .click();
    }
}
