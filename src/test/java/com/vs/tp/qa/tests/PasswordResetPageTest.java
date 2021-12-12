package com.vs.tp.qa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.PasswordReset;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.utils.UseCaseBase;

public class PasswordResetPageTest extends UseCaseBase {
    public static LoginPage loginPage;
    public static PasswordReset forgotPassword;


    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        forgotPassword = new PasswordReset();
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
}
