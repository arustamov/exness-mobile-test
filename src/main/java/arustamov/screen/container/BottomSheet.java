package arustamov.screen.container;

import arustamov.screen.MobilePageObject;
import org.openqa.selenium.By;

public class BottomSheet extends MobilePageObject {

    private static final String CLOSE_SKIP_ID = "btnSkip";

    public void tapCloseSkip() {
        find(
            By.id(CLOSE_SKIP_ID)
        )
            .click();
    }
}
