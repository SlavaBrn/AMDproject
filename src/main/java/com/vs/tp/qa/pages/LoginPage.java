package com.vs.tp.qa.pages;

import com.vs.tp.qa.general.Const;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


    //1. Success (with a few promotions):
    public final String FEW_PROM_LOGIN = "anygfhdhsh@a.com";
    public final String FEW_PROM_PASSWORD = "testpass";
    public final String FEW_PROM_URL = "https://amdtp-mock-qa.phoenixfms.ca/promotions";

    //3. Server fail:
    private final String SERVER_ERROR_MESSAGE = "//span[text() = 'Request ID: req500']";


    public final String AUTH_FRAME = "//*[@id = 'auth-greeting']";
    public final String EMAIL_FIELD = "//input[@type = 'email']";
    public final String PASSWORD_FIELD = "//*[@type = 'password']";
    public final String SUBMIT_BUTTON = "//input[@type = 'submit']";
    private final String FORGOT_PASS_LINK = "//a[text() = 'Forgot password?']";
    private final String FORGOT_PASS_LINK_RU = "//a[text() = 'Забыли пароль?']";
    //    LANGUAGES
    private final String LANGUAGE_SELECTOR_EN = "//option[@value = 'EN']";
    private final String LANGUAGE_SELECTOR_RU = "//option[@value = 'RU']";
    private final String LANGUAGE_SELECTOR = "//*[@class = 'lang-selector']";
    private final String ACCOUNT_GREETING = "//*[text() = 'Log in to your account']";
    public final String ENTER_EMAIL_PLACEHOLDER = "//input[@placeholder = 'Enter your e-mail']";
    private final String PASSWORD_HEADER = "//span[text() = 'Password']";
    private final String ENTER_PASSWORD_PLACEHOLDER = "//*[@placeholder = 'Enter your password']";
    public final String SUBMIT_BUTTON_HEADER = "//input[@value = 'Login now']";

//    private final String RECORDS_ERROR = "//*[(text() = 'The email and password you entered do not match our records')]";
    public final String RECORDS_ERROR = "//span[text() =  'The email and password you entered']";
    private final String UNKNOWN_ERROR = "//span[text() = 'Request ID: req400']";



    public final String ACCOUNT_GREETING_russian = "//span[text() = 'Вход в аккаунт']";
    public final String ENTER_EMAIL_PLACEHOLDER_RU = "//input[@placeholder = 'Введите ваш e-mail']";
    private final String PASSWORD_HEADER_RU = "//span[text() = 'Пароль']";
    private final String ENTER_PASSWORD_PLACEHOLDER_RU = "//*[@placeholder = 'Введите ваш пароль']";
    public final String SUBMIT_BUTTON_HEADER_RU = "//input[@value = 'Войти']";

    public final String TEXT_PASSWORD_ICON = "//div[@class = 'icon-container icon-input']";
    public final String TEXT_VISIBLE = "//input[@type = 'text']";
    public final String PASSWORD_VISIBLE = "//input[@type = 'password']";

    private final String MANY_ATTEMPTS_MESSAGE = "//span[text() = 'Try again in a minute.']";



    public boolean IsLoginPageVisible() {
        return elementExists(AUTH_FRAME);
    }
    public boolean IsServerFailVisible() {
        sendKeysByXpath(EMAIL_FIELD,"server@<any");
        sendKeysByXpath(PASSWORD_FIELD,"hbdhejdbe");
        clickElementByXpath(SUBMIT_BUTTON);
        return elementExists(SERVER_ERROR_MESSAGE);
    }
    public Boolean isManyAttemptsMessageVisible() {
        sendKeysByXpath(EMAIL_FIELD,"many@jnei");
        sendKeysByXpath(PASSWORD_FIELD,"kcmr");
        clickElementByXpath(SUBMIT_BUTTON);
        return elementExists(MANY_ATTEMPTS_MESSAGE);
    }
    public Boolean isUnknownErrorMessageVisible() {
        sendKeysByXpath(EMAIL_FIELD,"else@<any");
        sendKeysByXpath(PASSWORD_FIELD,"kcmr");
        clickElementByXpath(SUBMIT_BUTTON);
        return elementExists(UNKNOWN_ERROR);
    }

    public boolean IsLForgotPasswordLink() {
        return elementExists(FORGOT_PASS_LINK);

    }
    public boolean IsLPasswordOrLoginIncorrect() {
        sendKeysByXpath(EMAIL_FIELD, "hgdeyd@a");
        sendKeysByXpath(PASSWORD_FIELD, "bsuxusxunxsnu");
        clickElementByXpath(SUBMIT_BUTTON);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RECORDS_ERROR)));
        return elementExists(RECORDS_ERROR);
    }


    public static void navigateLoginPage() {
        webDriver.get(Const.LOGIN_URL);
    }

    public FewPromPage openFewPromPage() {
        webDriver.get("https://amdtp-mock-qa.phoenixfms.ca/login");
        sendKeysByXpath(EMAIL_FIELD, FEW_PROM_LOGIN);
        sendKeysByXpath(PASSWORD_FIELD,FEW_PROM_PASSWORD);
        clickElementByXpath(SUBMIT_BUTTON);
        return new FewPromPage();
    }
    public static void openFewPromUrl(){
        webDriver.get("https://amdtp-mock-qa.phoenixfms.ca/login");
    }




    //        English Caption fields and Headers
    public String languageSelectorHeaderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(LANGUAGE_SELECTOR_EN).getAttribute("label");
    }


    public String loginHeaderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(ACCOUNT_GREETING).getText();
    }

    public String loginFieldPlaceholderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(ENTER_EMAIL_PLACEHOLDER).getAttribute("placeholder");
    }

    public String passwordHeaderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(PASSWORD_HEADER).getText();
    }

    public String loginPassFieldPlaceholderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(ENTER_PASSWORD_PLACEHOLDER).getAttribute("placeholder");
    }

    public String forgotPasswordLinkCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(FORGOT_PASS_LINK).getText();
    }

    public String loginNowButtonCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(SUBMIT_BUTTON_HEADER).getAttribute("value");
    }


    // Russian Caption fields and Headers

    public String languageSelectorHeaderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(LANGUAGE_SELECTOR_RU).getAttribute("label");
    }

    public String loginHeaderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(ACCOUNT_GREETING_russian).getText();
    }

    public String loginFieldPlaceholderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(ENTER_EMAIL_PLACEHOLDER_RU).getAttribute("placeholder");

    }
    public String passwordHeaderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(PASSWORD_HEADER_RU).getText();
    }

    public String loginPassFieldPlaceholderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(ENTER_PASSWORD_PLACEHOLDER_RU).getAttribute("placeholder");
    }

    public String forgotPasswordLinkCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(FORGOT_PASS_LINK_RU).getText();
    }

    public String loginNowButtonCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(SUBMIT_BUTTON_HEADER_RU).getAttribute("value");
    }

    // Password Login field- text hiding

    public String textOverPassword(){
        return findElementByXpath(TEXT_VISIBLE).getAttribute("type");
    }
    public String passwordOverText(){
        return findElementByXpath(PASSWORD_VISIBLE).getAttribute("type");
    }

    // Open Password Reset Page (by clicking on forgot password link)
    public PasswordResetPage openPasswordResetPage(){
        clickElementByXpath(FORGOT_PASS_LINK);
        return new PasswordResetPage();
    }

    public RegisterNewUserPage openRegisterNewUserPage(){
        sendKeysByXpath(EMAIL_FIELD,"admin@a.com");
        sendKeysByXpath(PASSWORD_FIELD,"testpass");
        clickElementByXpath(SUBMIT_BUTTON);
        return new RegisterNewUserPage();
    }

    public SetUpNewPasswordPage openSutUpNewPasswordPage(){
        sendKeysByXpath(EMAIL_FIELD,"change@a.com");
        sendKeysByXpath(PASSWORD_FIELD,"testpass");
        clickElementByXpath(SUBMIT_BUTTON);
        return new SetUpNewPasswordPage();

    }
    public SetUpNewPasswordFailPage openSutUpNewPasswordWithFailPage(){
        sendKeysByXpath(EMAIL_FIELD,"changefail@a.com");
        sendKeysByXpath(PASSWORD_FIELD,"testpass");
        clickElementByXpath(SUBMIT_BUTTON);
        return new SetUpNewPasswordFailPage();
    }



}
