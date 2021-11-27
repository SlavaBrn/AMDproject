import Pages.BasePage;
import Pages.FewPromPage;
import Pages.ForgotPassword;
import Pages.LoginPage;
import Util.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import javax.xml.xpath.XPath;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTestPage extends UseCaseBase {


//    proba?

    private static final String active = "//*[text() ='Active']";
    private static final String text = "//*[contains(text(), 'Active')]";
    private static final String lock = "//*[@xmlns = 'http://www.w3.org/2000/svg']";

    public static LoginPage loginPage;
    public static ForgotPassword forgotPassword;


    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        forgotPassword = new ForgotPassword();

    }

    @BeforeEach
    public void beforeEachTest() {
        loginPage.navigateLoginPage();
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
    public void englishLoginCaptionCheck() {
        loginPage.loginHeaderCheck();
        String is0 = loginPage.languageSelectorHeaderCheck();
        assertEquals("English", is0);
        String is = loginPage.loginHeaderCheck();
        assertEquals("Log in to your account", is);
        String is1 =loginPage.loginFieldPlaceholderCheck();
        assertEquals("Enter your e-mail",is1);
        String is2 = loginPage.passwordHeaderCheck();
        assertEquals("Password",is2);
        String is3 =loginPage.loginPassFieldPlaceholderCheck();
        assertEquals("Enter your password",is3);
        String is4 = loginPage.forgotPasswordLinkCheck();
        assertEquals("Forgot password?",is4);
        String is5 = loginPage.loginNowButtonCheck();
        assertEquals("Login now",is5);

    }
    @Test
    public void russianLoginCaptionCheck(){
        String is0 = loginPage.languageSelectorHeaderCheckRu();
        assertEquals("Русский", is0);
        loginPage.loginHeaderCheck();
        String is = loginPage.loginHeaderCheckRu();
        assertEquals("Вход в аккаунт", is);
        String is1 =loginPage.loginFieldPlaceholderCheckRu();
        assertEquals("Введите ваш e-mail",is1);
        String is2 = loginPage.passwordHeaderCheckRu();
        assertEquals("Пароль",is2);
        String is3 =loginPage.loginPassFieldPlaceholderCheckRu();
        assertEquals("Введите ваш пароль",is3);
        String is4 = loginPage.forgotPasswordLinkCheckRu();
        assertEquals("Забыли пароль?",is4);
        String is5 = loginPage.loginNowButtonCheckRu();
        assertEquals("Войти",is5);
    }
    @Test
    public void passwordOrTextHiding(){
     loginPage.sendKeysByXpath(loginPage.PASSWORD_FIELD,"testpass");
     loginPage.clickElementByXpath(loginPage.TEXT_PASSWORD_ICON);
     String isText = loginPage.textOverPassword();
     assertEquals("text",isText);
     loginPage.clickElementByXpath(loginPage.TEXT_PASSWORD_ICON);
     String isPassword = loginPage.passwordOverText();
     assertEquals("password",isPassword);

    }
//    @Test
//    public void emptyEmailFieldError(){
//        String isError = loginPage.emailFieldEmpty();
//        assertEquals("Please fill all the fields.",isError);
//    }

}

