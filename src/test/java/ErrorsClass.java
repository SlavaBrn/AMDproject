import Pages.*;
import Util.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorsClass extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopup codeRequestPopup;
    public static PasswordReset passwordReset;
    public static PasswordResetCodePage passwordResetCodePage;

    @BeforeAll
    public static void pageSetup() {
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopup();
        loginPage = new LoginPage();
        passwordReset = new PasswordReset();
        passwordResetCodePage = new PasswordResetCodePage();
    }

    @BeforeEach
    public void Each() {
        LoginPage.navigateLoginPage();

//        fewPromPage = loginPage.openFewPromPage();
    }

    //    Reset Password Page(Forgot Password Link)
//    Limiter Fail
    @Test
    public void limiterFail() {
        passwordReset = loginPage.openPasswordResetPage();
        passwordReset.openLimiterError();
        boolean is = passwordReset.isManyAttemptsMessageVisible();
        assertTrue(is);
    }
//Code Submit Password Reset Page
//    Code Fail

    @Test
    public void codeFail() {
        loginPage.openPasswordResetPage();
        passwordReset.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.codeFail();
        assertTrue(is);
    }

    //    Unlock Popup
    //    Code Fail
    @Test
    public void noValidMessage() {
        loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.codeFail();
        boolean is = codeRequestPopup.isFailMessage();
        assertTrue(is);
    }

    //    Limiter Error
    @Test
    public void unknownError() {
        loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.limiterError();
        boolean is = codeRequestPopup.isLimiterErrorMessage();
        assertTrue(is);
    }
//    Login Page Errors

}
