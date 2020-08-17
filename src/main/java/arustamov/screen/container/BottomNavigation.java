package arustamov.screen.container;

import arustamov.screen.MobilePageObject;
import org.openqa.selenium.By;

public class BottomNavigation extends MobilePageObject {

    private static final String CONTAINER_ID = "bottomNavigationView";
    private static final String ICON_ID = "icon";
    private static final Integer WALLET_ICON_INDEX = 2;

    public void tapWalletIcon() {
        find(
            By.id(CONTAINER_ID)
        )
            .thenFindAll(
                By.id(ICON_ID)
            )
            .get(WALLET_ICON_INDEX)
            .click();
    }
}
