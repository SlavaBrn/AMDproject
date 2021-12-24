package com.vs.tp.qa.tests.PasswordchangedPageTest;

import com.vs.tp.qa.pages.*;
import com.vs.tp.qa.utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordChangedPasswordChangedPositiveTest extends UseCaseBase {
    public static LoginPage loginPage;
    public static PasswordResetPage forgotPassword;
    public static PasswordResetCodePage passwordResetCodePage;
    public static PasswordResetPage passwordResetPage;
    public static NewPasswordCreationPage newPasswordCreationPage;
    public static PasswordChangedPage passwordChangedPage;



    @BeforeAll
    public static void pageSetup() {
        forgotPassword = new PasswordResetPage();
        passwordResetCodePage = new PasswordResetCodePage();
        passwordResetPage = new PasswordResetPage();
        newPasswordCreationPage = new NewPasswordCreationPage();
        passwordChangedPage = new PasswordChangedPage();

    }

    @BeforeEach
    public void beforeEachTest() {
        forgotPassword.navigateToPasswordResetPage();

    }
    @Test
    public void backToLoginPage() {
        passwordResetPage.successOpenCodePasswordResetPage();
        passwordResetCodePage.openNewPasswordCreationPage();
        newPasswordCreationPage.passwordChanged();
        LoginPage loginPage = passwordChangedPage.goToLogin();
        boolean is = loginPage.IsLoginPageVisible();
        assertTrue(is);
    }
}
