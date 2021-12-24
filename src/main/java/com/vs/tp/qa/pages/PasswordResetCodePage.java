package com.vs.tp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordResetCodePage extends BasePage {
    private final String CODE_SUBMIT_FIELD = "//input[@id = 'code-submit-field']";
    private final String CODE_SUBMIT_BUTTON = "//input[@value = 'Submit code']";
    private final String CODE_FAIL_ERROR = "//span[text() = 'Please, enter a valid 6-digit code']";
    private final String SERVER_FAIL_ERROR = "//span[text() = 'Request ID: req500']";
    private final String UNKNOWN_ERROR = "//span[text() = 'Request ID: req400']";
    private final String LIMITER_FAIL = "//span[text() = 'Try again in a minute.']";
    private final String RESEND_BUTTON = "//button[text() = 'Resend code']";
    private final String RESEND_CODE_COUNT_DOWN = "//button[text() = 'Resend code (5)']";
    private final String BACK_TO_LOGIN_LINK = "//a[text() = 'Back to Login']";


    public boolean isCodeSubmitFieldPresent() {
        return elementExists(CODE_SUBMIT_FIELD);
    }


    public NewPasswordCreationPage openNewPasswordCreationPage() {
        sendKeysByXpath(CODE_SUBMIT_FIELD, "200000");
        clickElementByXpath(CODE_SUBMIT_BUTTON);
        return new NewPasswordCreationPage();
    }
    public boolean countDownResendCode(){
        clickElementByXpath(RESEND_BUTTON);
        return elementExists(RESEND_CODE_COUNT_DOWN);
    }
    public LoginPage backToLoginPage(){
     clickElementByXpath(BACK_TO_LOGIN_LINK);
     return new LoginPage();
    }
    
    public boolean codeFail(){
        sendKeysByXpath(CODE_SUBMIT_FIELD, "123456");
        clickElementByXpath(CODE_SUBMIT_BUTTON);
        return elementExists(CODE_FAIL_ERROR);
    }

    public boolean serverFail(){
        sendKeysByXpath(CODE_SUBMIT_FIELD, "500000");
        clickElementByXpath(CODE_SUBMIT_BUTTON);
        return elementExists(SERVER_FAIL_ERROR);
    }

    public boolean unknownError(){
        sendKeysByXpath(CODE_SUBMIT_FIELD, "400000");
        clickElementByXpath(CODE_SUBMIT_BUTTON);
        return elementExists(UNKNOWN_ERROR);
    }
    public boolean limiterFail(){
        sendKeysByXpath(CODE_SUBMIT_FIELD, "429000");
        clickElementByXpath(CODE_SUBMIT_BUTTON);
        return elementExists(LIMITER_FAIL);
    }
    public void failOnNewPasswordPage(){
        sendKeysByXpath(CODE_SUBMIT_FIELD, "200001");
        clickElementByXpath(CODE_SUBMIT_BUTTON);

    }

}
