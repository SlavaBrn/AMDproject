package com.vs.tp.qa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.assertTrue;

// import com.vs.tp.qa.annotations.DisabledForE2E;
import com.vs.tp.qa.pages.CodeRequestPopup;
import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.PasswordReset;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.utils.UseCaseBase;

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
    }

    //    Reset Password Page(Forgot Password Link)
    @Tag("fe")
    @Test
    public void limiterFail() {
        passwordReset = loginPage.openPasswordResetPage();
        passwordReset.openLimiterError();
        boolean is = passwordReset.isManyAttemptsMessageVisible();
        assertTrue(is);
    }

    @Test
    public void codeFail() {
        loginPage.openPasswordResetPage();
        passwordReset.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.codeFail();
        assertTrue(is);
    }

    @Test
    public void noValidMessage() {
        loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.codeFail();
        boolean is = codeRequestPopup.isFailMessage();
        assertTrue(is);
    }

    @Test
    // @DisabledForE2E
    @Tag("fe")
    @Tag("e2e")
    public void unknownError() {
        loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.limiterError();
        boolean is = codeRequestPopup.isLimiterErrorMessage();
        assertTrue(is);
    }
}
