package com.vs.tp.qa.pages;

public class PasswordChangedPage extends BasePage{
    public static String PASSWORD_CHANGED_HEADER= "//span[text() = 'Password changed!']";
    public static String GO_TO_LOGIN_BUTTON = "//button[text() = 'Go to login']";

   public boolean isHeaderVisible(){
      return elementExists(PASSWORD_CHANGED_HEADER);
   }
   public LoginPage goToLogin (){
       clickElementByXpath(GO_TO_LOGIN_BUTTON);
       return new LoginPage();
   }

}
