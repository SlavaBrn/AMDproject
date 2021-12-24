package com.vs.tp.qa.pages;

public class NewPasswordCreationPage extends BasePage {
    public static String SUBMIT_NEW_PASSWORD_BUTTON = "//input[@value = 'Submit new password']";
    public static String NEW_PASSWORD_FIELD = "//input[@placeholder = 'Enter new password']";
    public static String NEW_PASSWORD_CONFORMATION_FIELD = "//input[@placeholder = 'Confirm new password']";
    public static String FAIL_MESSAGE= "//span[text() = 'Request ID: req500']";
    public static String BACK_TO_LOGIN_LINK= "//a[text() = 'Back to Login']";

    public boolean isSubmitNewPasswordVisible(){
        return elementExists(SUBMIT_NEW_PASSWORD_BUTTON);
    }

    public boolean newPassFail(){
        sendKeysByXpath(NEW_PASSWORD_FIELD,"Ll123456");
        sendKeysByXpath(NEW_PASSWORD_CONFORMATION_FIELD,"Ll123456");
        clickElementByXpath(SUBMIT_NEW_PASSWORD_BUTTON);
        return elementExists(FAIL_MESSAGE);
    }
    public PasswordChangedPage passwordChanged(){
        sendKeysByXpath(NEW_PASSWORD_FIELD,"Ll123456");
        sendKeysByXpath(NEW_PASSWORD_CONFORMATION_FIELD,"Ll123456");
        clickElementByXpath(SUBMIT_NEW_PASSWORD_BUTTON);
        return new PasswordChangedPage();
    }
    public LoginPage backToLoginPage(){
        clickElementByXpath(BACK_TO_LOGIN_LINK);
        return new LoginPage();
    }


}
