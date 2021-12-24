package com.vs.tp.qa.tests.PasswordResetCodeSubmitTests;

import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.NewPasswordCreationPage;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.pages.PasswordResetPage;
import com.vs.tp.qa.utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.NewPasswordCreationPage;
import com.vs.tp.qa.pages.PasswordResetPage;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordResetCodePasswordResetCodeNegativeTest extends UseCaseBase {
    public static LoginPage loginPage;
    public static PasswordResetPage forgotPassword;
    public static PasswordResetCodePage passwordResetCodePage;
    public static PasswordResetPage passwordResetPage;
    public static NewPasswordCreationPage newPasswordCreationPage;

    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        forgotPassword = new PasswordResetPage();
        passwordResetCodePage = new PasswordResetCodePage();
        passwordResetPage = new PasswordResetPage();
        newPasswordCreationPage = new NewPasswordCreationPage();
    }

    @BeforeEach
    public void beforeEachTest() {
        forgotPassword.navigateToPasswordResetPage();
    }
    @Test
    public void codeFail() {
        passwordResetPage.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.codeFail();
        assertTrue(is);
    }
    @Test
    public void serverFail() {
        passwordResetPage.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.serverFail();
        assertTrue(is);
    }
    @Test
    public void limiterFail() {
        passwordResetPage.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.limiterFail();
        assertTrue(is);
    }
    @Test
    public void unknownError() {
        passwordResetPage.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.unknownError();
        assertTrue(is);
    }
//    6. Fail on “new password” page:
    @Test
    public void failOnNewPasswordPage(){
        passwordResetPage.successOpenCodePasswordResetPage();
        passwordResetCodePage.failOnNewPasswordPage();
       boolean is = newPasswordCreationPage.newPassFail();
        assertTrue(is);
    }





}
