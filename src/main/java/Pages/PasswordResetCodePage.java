package Pages;

public class PasswordResetCodePage extends BasePage{
    private final String CODE_SUBMIT_FIELD = "//input[@id = 'code-submit-field']";
    
    public String isCodeSubmitFieldPresent(){
        return findElementByXpath(CODE_SUBMIT_FIELD).getAttribute("id");
    }

}
