package com.vs.tp.qa.pages;

public class SuccessPopupPage extends BasePage{

    private final String SUCCESS_MESSAGE    = "//*[text() = 'Successfully unlocked.']";
    private final String CONTINUE_BUTTON    = "//*[text() = 'Continue']";

    public boolean isSuccessMessageVisible(){
        return elementExists(SUCCESS_MESSAGE);
    }

    public FewPromPage returnToFewPromPage(){
        clickElementByXpath(CONTINUE_BUTTON);
        return new FewPromPage();
    }
}
