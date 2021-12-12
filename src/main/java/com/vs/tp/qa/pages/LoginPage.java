package com.vs.tp.qa.pages;

import com.vs.tp.qa.general.Const;

public class LoginPage extends BasePage {

    //1. Success (with a few promotions):
    public final String FEW_PROM_LOGIN = "anygfhdhsh@a.com";
    public final String FEW_PROM_PASSWORD = "testpass";

    //1a. Success (with many promotions):
    public final String MANY_PROM_LOGIN = "long@a.com";
    public final String MANY_PROM_PASSWORD = "testpass";

    //1b. Success admin:
    public final String SUCCESS_ADMIN_LOGIN = "admin@a.com";
    public final String SUCCESS_ADMIN_PASSWORD = "testpass";

    //1c. Success (need to change password):
    public final String SUCCESS_CHANGE_PASS_LOGIN = "change@a.com";
    public final String SUCCESS_CHANG_PASS_PASSWORD = "testpass";

    //1d. Success (need to change password and the change will fail):
    public final String SUCCESS_CHANGE_PASS_FAIL_LOGIN = "changefail@a.com";
    public final String SUCCESS_CHANGE_PASS_FAIL_PASSWORD = "testpass";

    //1e. Success (5 seconds auth JWT life):
    public final String SUCCESS_JWT_LOGIN = "seccion@a.com";
    public final String SUCCESS_JWT_PASSWORD = "testpass";

    //2. Fail (wrong credentials):
    public final String FAIL_LOGIN = "any";
    public final String FAIL_PASSWORD = "any, except 'testpass'";

    //3. Server fail:
    public final String login = "server@<any valid domain name>";
    public final String password = "any";

    //4. Limiter fail:
    public final String LIMITER_FAIL_LOGIN = "many@<any valid domain name>";
    public final String LIMITER_FAIL_PASSWORD = "any";

    //5. Unknown error:
    public final String UNKNOWN_ERROR_LOGIN = "else@<any valid domain name>";
    public final String UNKNOWN_ERROR_PASSWORD = "any";

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
    private final String RECORDS_ERROR = "//span[@class =  'error-text error-show']";



    public final String ACCOUNT_GREETING_russian = "//span[text() = 'Вход в аккаунт']";
    public final String ENTER_EMAIL_PLACEHOLDER_RU = "//input[@placeholder = 'Введите ваш e-mail']";
    private final String PASSWORD_HEADER_RU = "//span[text() = 'Пароль']";
    private final String ENTER_PASSWORD_PLACEHOLDER_RU = "//*[@placeholder = 'Введите ваш пароль']";
    public final String SUBMIT_BUTTON_HEADER_RU = "//input[@value = 'Войти']";

    public final String TEXT_PASSWORD_ICON = "//div[@class = 'icon-container icon-input']";
    public final String TEXT_VISIBLE = "//input[@type = 'text']";
    public final String PASSWORD_VISIBLE = "//input[@type = 'password']";



    public boolean IsLoginPageVisible() {
        return elementExists(AUTH_FRAME);

    }
    public boolean IsLForgotPasswordLink() {
        return elementExists(FORGOT_PASS_LINK);

    }
    public boolean IsLPasswordOrLoginIncorrect() {
        return elementExists(RECORDS_ERROR);
    }


    public static void navigateLoginPage() {
        webDriver.get(Const.LOGIN_URL);
    }

    public FewPromPage openFewPromPage() {
        sendKeysByXpath(EMAIL_FIELD, FEW_PROM_LOGIN);
        sendKeysByXpath(PASSWORD_FIELD,FEW_PROM_PASSWORD);
        clickElementByXpath(SUBMIT_BUTTON);
        return new FewPromPage();
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
    public PasswordReset openPasswordResetPage(){
        clickElementByXpath(FORGOT_PASS_LINK);
        return new PasswordReset();
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
