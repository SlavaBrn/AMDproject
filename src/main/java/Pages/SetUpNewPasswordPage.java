package Pages;

public class SetUpNewPasswordPage extends BasePage{
    private final String NEW_PASSWORD_HEADER = "//*[text() = 'Set up new password']";


    public String isNewPasswordHeaderVisible(){
        return findElementByXpath(NEW_PASSWORD_HEADER).getText();
    }

}
