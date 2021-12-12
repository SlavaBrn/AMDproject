package com.vs.tp.qa.pages;

public class NewPasswordCreationPage extends BasePage {
    public static String SUBMIT_NEW_PASSWORD_BUTTON = "//input[@value = 'Submit new password']";

    public boolean isSubmitNewPasswordVisible(){
        return elementExists(SUBMIT_NEW_PASSWORD_BUTTON);
    }
}
