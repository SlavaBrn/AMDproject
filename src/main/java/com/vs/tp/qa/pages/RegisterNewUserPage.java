package com.vs.tp.qa.pages;

public class RegisterNewUserPage extends BasePage{
    private final String NEW_USER_HEADER = "//*[text() = 'Register a new user']";

    public String isNewUserHeaderVisible(){
        return findElementByXpath(NEW_USER_HEADER).getText();
    }
}
