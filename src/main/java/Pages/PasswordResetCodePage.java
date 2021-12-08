package Pages;

public class PasswordResetCodePage extends BasePage {
    private final String CODE_SUBMIT_FIELD = "//input[@id = 'code-submit-field']";
    private final String CODE_SUBMIT_BUTTON = "//input[@value = 'Submit code']";
    private final String CODE_FAIL_ERROR = "//span[text() = 'Please, enter a valid 6-digit code']";
    private final String SERVER_FAIL_ERROR = "//span[text() = 'Request ID: req500']";
    private final String UNKNOWN_ERROR = "//span[text() = 'Request ID: req400']";

    public boolean isCodeSubmitFieldPresent() {
        return elementExists(CODE_SUBMIT_FIELD);
    }

    public NewPasswordCreationPage openNewPasswordCreationPage() {
        sendKeysByXpath(CODE_SUBMIT_FIELD, "200000");
        clickElementByXpath(CODE_SUBMIT_BUTTON);
        return new NewPasswordCreationPage();
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

}
