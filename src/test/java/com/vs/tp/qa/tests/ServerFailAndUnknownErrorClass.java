package com.vs.tp.qa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.CodeRequestPopup;
import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.PasswordReset;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.utils.UseCaseBase;

public class ServerFailAndUnknownErrorClass extends UseCaseBase {
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
//    Server Fail

    @Test
    public void serverFail() {
        passwordReset = loginPage.openPasswordResetPage();
        passwordReset.openServerFailError();
        boolean is = passwordReset.isServerErrorMessageVisible();
        assertTrue(is);
    }

    //    Unknown Error
    @Test
    public void unknownResetPassError() {
        passwordReset = loginPage.openPasswordResetPage();
        passwordReset.openUnknownError();
        boolean is = passwordReset.isUnknownErrorMessageVisible();
        assertTrue(is);
    }

    //Code pop up request page
//    Server failed
    @Test
    public void serverFailedMessage() {
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.serverFail();
        boolean is = codeRequestPopup.isServerFailMessage();
        assertTrue(is);
    }

    //    Unknown Error
    @Test
    public void unknownError() {
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.unknownError();
        boolean is = codeRequestPopup.isUnknownErrorMessage();
        assertTrue(is);
    }

    //Code Submit Password Reset Page
//    Server Fail
    @Test
    public void passwordResetServerCodeFail() {
        loginPage.openPasswordResetPage();
        passwordReset.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.serverFail();
        assertTrue(is);
    }

    @Test
    public void passwordResetCodeUnknownError() {
        loginPage.openPasswordResetPage();
        passwordReset.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.unknownError();
        assertTrue(is);
    }
}
