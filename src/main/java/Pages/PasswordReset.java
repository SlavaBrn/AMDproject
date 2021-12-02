package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordReset extends BasePage {
    private final String PASSWORD_RESET_HEADER = "//span[text() = 'Password reset']";
    private final String EMAIL_FIELD = "//input[@type = 'email']";
    private final String SEND_CODE_BUTTON = "//input[@type = 'submit']";
    private final String BACK_TO_LOGIN_LINK = "//a[text() = 'Back to Login']";
    private final String MANY_ATTEMPTS_MESSAGE = "//span[text() = 'Try again in a minute.']";
    private final String SERVER_ERROR_MESSAGE = "//span[text() = 'Request ID: req500']";
    private final String UNKNOWN_ERROR_MESSAGE = "//span[text() = 'Request ID: req400']";



    public Boolean isBackToLoginVisible() {
        return elementExists(BACK_TO_LOGIN_LINK);
    }

    public PasswordResetCodePage successOpenCodePasswordResetPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PASSWORD_RESET_HEADER)));
        sendKeysByXpath(EMAIL_FIELD,"hdehcd@jden.com");
        clickElementByXpath(SEND_CODE_BUTTON);
        return new PasswordResetCodePage();
    }
    public void openLimiterError() {
        sendKeysByXpath(EMAIL_FIELD, " many@chde.com");
        clickElementByXpath(SEND_CODE_BUTTON);
    }
    public Boolean isManyAttemptsMessageVisible() {
        return elementExists(MANY_ATTEMPTS_MESSAGE);
    }
    public void openServerFailError() {
        sendKeysByXpath(EMAIL_FIELD, " server@chde.com");
        clickElementByXpath(SEND_CODE_BUTTON);
    }
    public Boolean isServerErrorMessageVisible() {
        return elementExists(SERVER_ERROR_MESSAGE);
    }
    public void openUnknownError() {
        sendKeysByXpath(EMAIL_FIELD, " else@chde.com");
        clickElementByXpath(SEND_CODE_BUTTON);
    }
    public Boolean isUnknownErrorMessageVisible() {
        return elementExists(UNKNOWN_ERROR_MESSAGE);
    }


}
