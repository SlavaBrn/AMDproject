package com.vs.tp.qa.tests.LoginPageTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.PasswordResetPage;
import com.vs.tp.qa.pages.RegisterNewUserPage;
import com.vs.tp.qa.pages.SetUpNewPasswordPage;
import com.vs.tp.qa.utils.UseCaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLoginNegativeTest extends UseCaseBase {
    private static final String INCOMPLETE_EMAIL1 = "ddeuud@";
    private static final String INCOMPLETE_MAIL2 = "@a.com";
    private static final String INCOMPLETE_MAIL3 = "@";
    private static final String EMAIL_EMPTY = "            ";
    private static final String MAIL_ONLY_LETTERS = "jdejndejd";

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
    }

    //    Incorrect Credentials message "The email and password you entered do not match our records"

    @ParameterizedTest
    @ValueSource(strings = {INCOMPLETE_EMAIL1, INCOMPLETE_MAIL2, INCOMPLETE_MAIL3, EMAIL_EMPTY, MAIL_ONLY_LETTERS})
    public void emailFieldNegative(String input) {
        loginPage.sendKeysByXpath(loginPage.PASSWORD_FIELD, "testpass");
        loginPage.sendKeysByXpath(loginPage.EMAIL_FIELD, input);
        loginPage.clickElementByXpath(loginPage.SUBMIT_BUTTON);
        boolean is = loginPage.IsLForgotPasswordLink();
        assertTrue(is);
    }
//    Wrong Credentials
    @Test
    public void incorrectCredentials() {
        boolean is = loginPage.IsLPasswordOrLoginIncorrect();
        assertTrue(is);
    }
//  3  Server fail:
    @Test
    public void isLoginServerPageFail(){
        boolean is = loginPage.IsServerFailVisible();
        assertTrue(is);
    }
//    4.Limiter Fail
    @Test
    public void isLimiterMessage(){
        boolean is = loginPage.isManyAttemptsMessageVisible();
        assertTrue(is);
    }
//    5.Unknown error

    @Test
    public void isUnknownErrorMessage(){
        boolean is = loginPage.isUnknownErrorMessageVisible();
        assertTrue(is);
    }




}
