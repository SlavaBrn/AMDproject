import Pages.*;
import Util.UseCaseBase;
import Util.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ServerFailAndUnknownError extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopup codeRequestPopup;
    public static PasswordReset passwordReset;

    @BeforeAll
    public static void pageSetup() {
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopup();
        loginPage = new LoginPage();
        passwordReset = new PasswordReset();
    }

    @BeforeEach
    public void Each() {
        LoginPage.navigateLoginPage();
    }
    //    Reset Password Page(Forgot Password Link)
//    Server Fail

    @Test
    public void serverFail() {
        passwordReset = loginPage.openPasswordResetPage();
        passwordReset.openServerFailError();
        boolean is = passwordReset.isServerErrorMessageVisible();
        assertTrue(is);
    }
    @Test
    public void unknownResetPassError() {
        passwordReset = loginPage.openPasswordResetPage();
        passwordReset.openUnknownError();
        boolean is = passwordReset.isUnknownErrorMessageVisible();
        assertTrue(is);
    }


//    Server failed
    @Test
    public void serverFailedMessage(){
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.serverFail();
        boolean is = codeRequestPopup.isServerFailMessage();
        assertTrue(is);
    }
//    Unknown Error
    @Test
    public void unknownError(){
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.unknownError();
        boolean is = codeRequestPopup.isUnknownErrorMessage();
        assertTrue(is);
    }



}
