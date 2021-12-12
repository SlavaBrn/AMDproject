package com.vs.tp.qa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.NewPasswordCreationPage;
import com.vs.tp.qa.pages.PasswordReset;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.utils.UseCaseBase;


public class PasswordResetCodePageTest extends UseCaseBase {
    public static LoginPage loginPage;
    public static PasswordReset forgotPassword;
    public static PasswordResetCodePage passwordResetCodePage;

    
    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        forgotPassword = new PasswordReset();
        passwordResetCodePage = new PasswordResetCodePage();
    }

    @BeforeEach
    public void beforeEachTest() {
        LoginPage.navigateLoginPage();
        loginPage.openPasswordResetPage();
        forgotPassword.successOpenCodePasswordResetPage();
    }

    @Test
    public void CreationPasswordPageTest(){
        NewPasswordCreationPage newPasswordCreationPage = passwordResetCodePage.openNewPasswordCreationPage();
        boolean is = newPasswordCreationPage.isSubmitNewPasswordVisible();
        assertTrue(is);
    }
}