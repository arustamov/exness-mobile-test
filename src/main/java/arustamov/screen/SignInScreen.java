package arustamov.screen;

import org.openqa.selenium.By;

public class SignInScreen extends MobilePageObject {

    private static final String EMAIL_ID = "emailView";
    private static final String PASSWORD_ID = "passwordView";
    private static final String SIGN_IN_ID = "signInView";

    public void typeInEmail(String email) {
        find(
            By.id(EMAIL_ID)
        )
            .type(email);
    }

    public void typeInPassword(String password) {
        find(
            By.id(PASSWORD_ID)
        )
            .type(password);
    }

    public void tapSignIn() {
        find(
            By.id(SIGN_IN_ID)
        )
            .click();
    }
}
