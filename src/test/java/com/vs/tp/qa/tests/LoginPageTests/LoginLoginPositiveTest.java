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

public class LoginLoginPositiveTest extends UseCaseBase {
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

//    Login Page

    @Test
    public void loginPageLoadTest() {
        boolean isVisible = loginPage.IsLoginPageVisible();
        assertTrue(isVisible);
    }
//Few Ppromotion Page
    @Test
    public void fewPromPageTest() {
        FewPromPage fewPromPage = loginPage.openFewPromPage();
        String isPage = fewPromPage.isPromotion0Visible();
        assertEquals("Promotion", isPage);
    }
// Success admin(Password Reset)
    @Test
    public void passwordResetTest(){
        PasswordResetPage passwordReset = loginPage.openPasswordResetPage();
        boolean is = passwordReset.isBackToLoginVisible();
        assertTrue(is);
    }
    // 1c   Success (need to change password)-Set up new password page
    @Test
    public void openNewPasswordPage() {
        SetUpNewPasswordPage setUpNewPasswordPage = loginPage.openSutUpNewPasswordPage();
        String is = setUpNewPasswordPage.isNewPasswordHeaderVisible();
        assertEquals("Set up new password", is);
    }
    // 1d Success (need to change password and the change will fail) NEw User Register Page
    @Test
    public void openRegisterNewUserPage() {
        RegisterNewUserPage registerNewUserPage = loginPage.openRegisterNewUserPage();
        String is = registerNewUserPage.isNewUserHeaderVisible();
        assertEquals("Register a new user", is);
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
        assertEquals("??????????????", is0);
        loginPage.loginHeaderCheck();
        String is = loginPage.loginHeaderCheckRu();
        assertEquals("???????? ?? ??????????????", is);
        String is1 = loginPage.loginFieldPlaceholderCheckRu();
        assertEquals("?????????????? ?????? e-mail", is1);
        String is2 = loginPage.passwordHeaderCheckRu();
        assertEquals("????????????", is2);
        String is3 = loginPage.loginPassFieldPlaceholderCheckRu();
        assertEquals("?????????????? ?????? ????????????", is3);
        String is4 = loginPage.forgotPasswordLinkCheckRu();
        assertEquals("???????????? ?????????????", is4);
        String is5 = loginPage.loginNowButtonCheckRu();
        assertEquals("??????????", is5);
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





}