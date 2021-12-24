package com.vs.tp.qa.tests.NewPasswordCreationPage;

import com.vs.tp.qa.pages.*;
import com.vs.tp.qa.utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewPasswordCreationPageNewPasswordCreationPagePositiveTests extends UseCaseBase {
    public static LoginPage loginPage;
    public static PasswordResetPage forgotPassword;
    public static PasswordResetCodePage passwordResetCodePage;
    public static PasswordResetPage passwordResetPage;
    public static NewPasswordCreationPage newPasswordCreationPage;



    @BeforeAll
    public static void pageSetup() {
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
    public void passwordChangedPage() {
        passwordResetPage.successOpenCodePasswordResetPage();
        passwordResetCodePage.openNewPasswordCreationPage();
        PasswordChangedPage passwordChangedPage = newPasswordCreationPage.passwordChanged();
        boolean is = passwordChangedPage.isHeaderVisible();
        assertTrue(is);
    }

    @Test
    public void backToLoginPage(){
        passwordResetPage.successOpenCodePasswordResetPage();
        passwordResetCodePage.openNewPasswordCreationPage();
        LoginPage loginPage = newPasswordCreationPage.backToLoginPage();
        boolean is = loginPage.IsLoginPageVisible();
        assertTrue(is);
    }
}
