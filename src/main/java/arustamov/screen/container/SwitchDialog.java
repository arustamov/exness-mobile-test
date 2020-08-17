package arustamov.screen.container;

import arustamov.screen.MobilePageObject;
import org.openqa.selenium.By;

public class SwitchDialog extends MobilePageObject {

    private static final String CONFIRM_ID = "android:id/button1";
    private static final String CANCEL_ID = "android:id/button2";

    public void tapConfirm() {
        find(
            By.id(CONFIRM_ID)
        )
            .click();
    }

    public void tapCancel() {
        find(
            By.id(CANCEL_ID)
        )
            .click();
    }
}
