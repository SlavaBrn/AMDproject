package com.vs.tp.qa.tests.PasswordResetPageTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.PasswordResetPage;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.utils.UseCaseBase;

public class PasswordResetPasswordResetPositiveTest extends UseCaseBase {
    public static LoginPage loginPage;
    public static PasswordResetPage forgotPassword;


    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        forgotPassword = new PasswordResetPage();
    }

    @BeforeEach
    public void beforeEachTest() {
        LoginPage.navigateLoginPage();
        loginPage.openPasswordResetPage();
    }
    
    @Test
    public void codePasswordResetPage(){
        PasswordResetCodePage passwordResetCodePage = forgotPassword.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.isCodeSubmitFieldPresent();
        assertTrue(is);
    }
    @Test
    public void backToLogIn(){
        LoginPage newLoginPage = forgotPassword.backToLoginPage();
        boolean is = newLoginPage.IsLoginPageVisible();
        assertTrue(is);
    }

}

