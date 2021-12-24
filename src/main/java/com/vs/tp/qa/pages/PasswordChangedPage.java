package com.vs.tp.qa.pages;

public class PasswordChangedPage extends BasePage{
    public static String PASSWORD_CHANGED_HEADER= "//span[text() = 'Password changed!']";

   public boolean isHeaderVisible(){
      return elementExists(PASSWORD_CHANGED_HEADER);

   }
}
