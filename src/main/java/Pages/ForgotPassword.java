package Pages;

public class ForgotPassword extends BasePage{
    private final String PASSWORD_RESET_HEADER = "//span[text() = 'Password reset']";
    public Boolean isForgotPassVisible(){
        return elementExists(PASSWORD_RESET_HEADER);
    }

}
