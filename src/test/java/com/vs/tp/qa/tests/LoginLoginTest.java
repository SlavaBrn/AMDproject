package com.vs.tp.qa.tests;

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

public class LoginLoginTest extends UseCaseBase {
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

//    Negative test: incomplete chars in E-mail field with the correct password

    @ParameterizedTest
    @ValueSource(strings = {INCOMPLETE_EMAIL1, INCOMPLETE_MAIL2, INCOMPLETE_MAIL3, EMAIL_EMPTY, MAIL_ONLY_LETTERS})
    public void emailFieldNegative(String input) {
        loginPage.sendKeysByXpath(loginPage.PASSWORD_FIELD, "testpass");
        loginPage.sendKeysByXpath(loginPage.EMAIL_FIELD, input);
        loginPage.clickElementByXpath(loginPage.SUBMIT_BUTTON);
        boolean is = loginPage.IsLForgotPasswordLink();
        assertTrue(is);
    }

    //    Incorrect Credentials message "The email and password you entered do not match our records"
    @Test
    public void incorrectCredentials() {
        loginPage.sendKeysByXpath(loginPage.EMAIL_FIELD, "hgdeyd@a");
        loginPage.sendKeysByXpath(loginPage.PASSWORD_FIELD, "bsuxusxunxsnu");
        loginPage.clickElementByXpath(loginPage.SUBMIT_BUTTON);
        boolean is = loginPage.IsLPasswordOrLoginIncorrect();
        assertTrue(is);
    }

    @Test
    public void loginPageLoadTest() {
        boolean isVisible = loginPage.IsLoginPageVisible();
        assertTrue(isVisible);
    }

    @Test
    public void fewPromPageTest() {
        FewPromPage fewPromPage = loginPage.openFewPromPage();
        String isPage = fewPromPage.isPromotion0Visible();
        assertEquals("Promotion", isPage);
    }
    @Test
    public void passwordResetTest(){
        PasswordResetPage passwordReset = loginPage.openPasswordResetPage();
        boolean is = passwordReset.isBackToLoginVisible();
        assertTrue(is);
    }


    @Test
    public void englishLoginCaptionCheck() {
        loginPage.loginHeaderCheck();
        String is0 = loginPage.languageSelectorHeaderCheck();
        assertEquals("English", is0);
        String is = loginPage.loginHeaderCheck();
        assertEquals("Log in to your account", is);
        String is1 = loginPage.loginFieldPlaceholderCheck();
        assertEquals("Enter your e-mail", is1);
        String is2 = loginPage.passwordHeaderCheck();
        assertEquals("Password", is2);
        String is3 = loginPage.loginPassFieldPlaceholderCheck();
        assertEquals("Enter your password", is3);
        String is4 = loginPage.forgotPasswordLinkCheck();
        assertEquals("Forgot password?", is4);
        String is5 = loginPage.loginNowButtonCheck();
        assertEquals("Login now", is5);
    }

    @Test
    public void russianLoginCaptionCheck() {
        String is0 = loginPage.languageSelectorHeaderCheckRu();
        assertEquals("Русский", is0);
        loginPage.loginHeaderCheck();
        String is = loginPage.loginHeaderCheckRu();
        assertEquals("Вход в аккаунт", is);
        String is1 = loginPage.loginFieldPlaceholderCheckRu();
        assertEquals("Введите ваш e-mail", is1);
        String is2 = loginPage.passwordHeaderCheckRu();
        assertEquals("Пароль", is2);
        String is3 = loginPage.loginPassFieldPlaceholderCheckRu();
        assertEquals("Введите ваш пароль", is3);
        String is4 = loginPage.forgotPasswordLinkCheckRu();
        assertEquals("Забыли пароль?", is4);
        String is5 = loginPage.loginNowButtonCheckRu();
        assertEquals("Войти", is5);
    }

    @Test
    public void passwordOrTextHiding() {
        loginPage.sendKeysByXpath(loginPage.PASSWORD_FIELD, "testpass");
        loginPage.clickElementByXpath(loginPage.TEXT_PASSWORD_ICON);
        String isText = loginPage.textOverPassword();
        assertEquals("text", isText);
        loginPage.clickElementByXpath(loginPage.TEXT_PASSWORD_ICON);
        String isPassword = loginPage.passwordOverText();
        assertEquals("password", isPassword);
    }

    //    Admin Section
//    Opening new page success
    @Test
    public void openRegisterNewUserPage() {
        RegisterNewUserPage registerNewUserPage = loginPage.openRegisterNewUserPage();
        String is = registerNewUserPage.isNewUserHeaderVisible();
        assertEquals("Register a new user", is);
    }

    //    Success (need to change password)
    @Test
    public void openNewPasswordPage() {
        SetUpNewPasswordPage setUpNewPasswordPage = loginPage.openSutUpNewPasswordPage();
        String is = setUpNewPasswordPage.isNewPasswordHeaderVisible();
        assertEquals("Set up new password", is);
    }
//    Success (need to change password and the change will fail)

}