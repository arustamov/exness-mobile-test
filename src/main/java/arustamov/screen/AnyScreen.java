package arustamov.screen;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

public class AnyScreen extends MobilePageObject {

    public Boolean isDisplayed() {
        return getRenderedElementsCount() > 0;
    }

    public void waitForScreenRendered() {
        waitFor(
            driver -> getPageSource().equals(
                getPageSource()
            )
        );
    }

    public void goBack() {
        WebDriver driver = ThucydidesWebDriverSupport.getProxiedDriver();
        if (driver instanceof PressesKey) {
            ((PressesKey) driver).pressKey(
                new KeyEvent(AndroidKey.BACK)
            );
        } else {
            throw new RuntimeException("Driver doesn't support press key");
        }
    }
}
