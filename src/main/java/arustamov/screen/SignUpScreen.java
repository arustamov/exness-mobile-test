package arustamov.screen;

import org.openqa.selenium.By;

public class SignUpScreen extends MobilePageObject {

    private static final String SIGN_IN_WITH_EXNESS_ACCOUNT_ID = "btnSignIn";

    public void tapSignInWithExnessAccount() {
        find(
            By.id(SIGN_IN_WITH_EXNESS_ACCOUNT_ID)
        )
            .click();
    }
}
