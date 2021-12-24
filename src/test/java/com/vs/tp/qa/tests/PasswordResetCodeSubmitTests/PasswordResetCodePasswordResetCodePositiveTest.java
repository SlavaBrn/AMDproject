package com.vs.tp.qa.tests.PasswordResetCodeSubmitTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.NewPasswordCreationPage;
import com.vs.tp.qa.pages.PasswordResetPage;
import com.vs.tp.qa.pages.PasswordResetCodePage;
import com.vs.tp.qa.utils.UseCaseBase;


public class PasswordResetCodePasswordResetCodePositiveTest extends UseCaseBase {
    public static LoginPage loginPage;
    public static PasswordResetPage forgotPassword;
    public static PasswordResetCodePage passwordResetCodePage;

    
    @BeforeAll
    public static void pageSetup() {
//        loginPage = new LoginPage();
        forgotPassword = new PasswordResetPage();
        passwordResetCodePage = new PasswordResetCodePage();
    }

    @BeforeEach
    public void beforeEachTest() {
//        LoginPage.navigateLoginPage();
//        loginPage.openPasswordResetPage();
        forgotPassword.navigateToPasswordResetPage();

    }

    @Test
    public void CreationPasswordPageTest(){
        forgotPassword.successOpenCodePasswordResetPage();
        NewPasswordCreationPage newPasswordCreationPage = passwordResetCodePage.openNewPasswordCreationPage();
        boolean is = newPasswordCreationPage.isSubmitNewPasswordVisible();
        assertTrue(is);
    }
    @Test
    public void resendCodeCountDownTest(){
        forgotPassword.successOpenCodePasswordResetPage();
        boolean is = passwordResetCodePage.countDownResendCode();
        assertTrue(is);
    }
    @Test
    public void BackToLogin(){
        forgotPassword.successOpenCodePasswordResetPage();
        LoginPage loginPage = passwordResetCodePage.backToLoginPage();
        boolean is = loginPage.IsLoginPageVisible();
        assertTrue(is);
    }


}
