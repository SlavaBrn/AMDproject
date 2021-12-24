package com.vs.tp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordResetPage extends BasePage {
    private final String PASSWORD_RESET_HEADER = "//span[text() = 'Password reset']";
    private final String EMAIL_FIELD = "//input[@type = 'email']";
    private final String SEND_CODE_BUTTON = "//input[@type = 'submit']";
    private final String BACK_TO_LOGIN_LINK = "//a[text() = 'Back to Login']";
    private final String MANY_ATTEMPTS_MESSAGE = "//span[text() = 'Try again in a minute.']";
    private final String SERVER_ERROR_MESSAGE = "//span[text() = 'Request ID: req500']";
    private final String UNKNOWN_ERROR_MESSAGE = "//span[text() = 'Request ID: req400']";
    private final String BackToLoginLink = "//a[text() = 'Back to Login']";
    private final String PASSWORD_RESET_PAGE_URL = "https://amdtp-mock-qa.phoenixfms.ca/reset";

    public void navigateToPasswordResetPage(){
        webDriver.get(PASSWORD_RESET_PAGE_URL);
    }


    public Boolean isBackToLoginVisible() {
        return elementExists(BACK_TO_LOGIN_LINK);
    }

    public LoginPage backToLoginPage() {
        clickElementByXpath(BackToLoginLink);
        return new LoginPage();
    }

    public PasswordResetCodePage successOpenCodePasswordResetPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PASSWORD_RESET_HEADER)));
        sendKeysByXpath(EMAIL_FIELD, "hdehcd@jden.com");
        clickElementByXpath(SEND_CODE_BUTTON);
        return new PasswordResetCodePage();
    }

    public boolean openLimiterError() {
        sendKeysByXpath(EMAIL_FIELD, " many@chde.com");
        clickElementByXpath(SEND_CODE_BUTTON);
        return elementExists(MANY_ATTEMPTS_MESSAGE);

    }

    public Boolean isManyAttemptsMessageVisible() {
        return elementExists(MANY_ATTEMPTS_MESSAGE);
    }

    public boolean openServerFailError() {
        sendKeysByXpath(EMAIL_FIELD, " server@chde.com");
        clickElementByXpath(SEND_CODE_BUTTON);
        return elementExists(SERVER_ERROR_MESSAGE);
    }

    public Boolean isServerErrorMessageVisible() {
        return elementExists(SERVER_ERROR_MESSAGE);
    }

    public boolean openUnknownError() {
        sendKeysByXpath(EMAIL_FIELD, " else@chde.com");
        clickElementByXpath(SEND_CODE_BUTTON);
        return elementExists(UNKNOWN_ERROR_MESSAGE);
    }

    public Boolean isUnknownErrorMessageVisible() {
        return elementExists(UNKNOWN_ERROR_MESSAGE);
    }


}
