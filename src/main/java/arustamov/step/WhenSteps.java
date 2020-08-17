package arustamov.step;

import arustamov.context.SpringContextAware;
import arustamov.screen.AnyScreen;
import arustamov.screen.ProfileScreen;
import arustamov.screen.SettingsScreen;
import arustamov.screen.SignInScreen;
import arustamov.screen.SignUpScreen;
import arustamov.screen.container.AppGuidePopup;
import arustamov.screen.container.BottomNavigation;
import arustamov.screen.container.BottomSheet;
import arustamov.screen.container.ProgressBar;
import arustamov.screen.container.SwitchDialog;
import arustamov.screen.container.Toolbar;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class WhenSteps implements SpringContextAware {

    private AnyScreen anyScreen;
    private ProgressBar progressBar;
    private AppGuidePopup appGuidePopup;
    private SignUpScreen signUpScreen;
    private SignInScreen signInScreen;
    private ProfileScreen profileScreen;
    private SettingsScreen settingsScreen;
    private Toolbar toolbar;
    private BottomSheet bottomSheet;
    private BottomNavigation bottomNavigation;
    private SwitchDialog switchDialog;

    @Step
    public void setSessionVariable(Object variableName, Object variableValue) {
        Serenity.setSessionVariable(variableName).to(variableValue);
    }

    @Step
    public void openApplication() {
        anyScreen.waitFor(
            driver -> anyScreen.isDisplayed()
        );
    }

    @Step
    public void waitForScreenTransition() {
        anyScreen.waitForScreenRendered();
    }

    @Step
    public void goBack() {
        anyScreen.goBack();
    }

    @Step
    public void waitForProgressBarDisplayed(final Boolean displayed) {
        progressBar.waitFor(
            driver -> displayed.equals(
                progressBar.isDisplayed()
            )
        );
    }

    @Step
    public void dismissAppGuideIfDisplayed() {
        if (appGuidePopup.isDisplayed()) {
            appGuidePopup.tapLater();
        }
    }

    @Step
    public void goToSignIn() {
        signUpScreen.tapSignInWithExnessAccount();
    }

    @Step
    public void provideEmailForSignIn(final String email) {
        signInScreen.typeInEmail(email);
    }

    @Step
    public void providePasswordForSignIn(final String password) {
        signInScreen.typeInPassword(password);
    }

    @Step
    public void trySignIn() {
        signInScreen.tapSignIn();
    }

    @Step
    public void trySignOut() {
        profileScreen.tapSignOut();
    }

    @Step
    public void skipSetPassCode() {
        toolbar.tapSkip();
    }

    @Step
    public void closeCryptoIntroduction() {
        bottomSheet.tapCloseSkip();
    }

    @Step
    public void skipOnboarding() {
        bottomSheet.tapCloseSkip();
    }

    @Step
    public void goToWallet() {
        bottomNavigation.tapWalletIcon();
    }

    @Step
    public void goToProfile() {
        toolbar.tapProfile();
    }

    @Step
    public void goToSettings() {
        toolbar.tapSettings();
    }

    @Step
    public void trySwitchEquityAlert() {
        settingsScreen.tapEquityAlert();
    }

    @Step
    public void confirmDialog() {
        switchDialog.tapConfirm();
    }

    @Step
    public void cancelDialog() {
        switchDialog.tapCancel();
    }

    @Step
    public void switchNewsFeedUpdates() {
        settingsScreen.tapNewsFeedUpdates();
    }
}
