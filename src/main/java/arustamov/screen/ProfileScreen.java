package arustamov.screen;

import org.openqa.selenium.By;

public class ProfileScreen extends MobilePageObject {

    private static final String SIGN_OUT_ID = "btnLogout";

    public void tapSignOut() {
        find(
            By.id(SIGN_OUT_ID)
        )
            .click();
    }
}
