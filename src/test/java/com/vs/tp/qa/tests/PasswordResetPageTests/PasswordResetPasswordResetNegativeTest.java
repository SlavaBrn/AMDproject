package com.vs.tp.qa.tests.PasswordResetPageTests;

import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.PasswordResetPage;
import com.vs.tp.qa.utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordResetPasswordResetNegativeTest extends UseCaseBase {
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
    public void serverFail() {
        boolean is = forgotPassword.openServerFailError();
        assertTrue(is);
    }
    @Tag("fe")
    @Test
    public void limiterFail() {
        boolean is = forgotPassword.openLimiterError();
        assertTrue(is);
    }
    @Test
    public void unknownErrorFail() {
        boolean is = forgotPassword.openUnknownError();
        assertTrue(is);
    }

}
