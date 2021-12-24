package com.vs.tp.qa.tests.UnlockPopupCodeSubmit;

import com.vs.tp.qa.pages.CodeRequestPopupPage;
import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodeRequestPopupCodeRequestPopupNegativeTest extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopupPage codeRequestPopup;

    @BeforeAll
    public static void pageSetup() {
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopupPage();
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void Each() {
//        LoginPage.navigateLoginPage();
        fewPromPage = loginPage.openFewPromPage();
    }
//    Code Fail
    @Test
    public void codeFail(){
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.codeFail();
        boolean is = codeRequestPopup.isFailMessage();
        assertTrue(is);
    }
    //    Server failed
    @Test
    public void serverFailedMessage() {
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.serverFail();
        boolean is = codeRequestPopup.isServerFailMessage();
        assertTrue(is);
    }
    //    Unknown Error
    @Test
    public void unknownError() {
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.unknownError();
        boolean is = codeRequestPopup.isUnknownErrorMessage();
        assertTrue(is);
    }
//    Limiter Fail
    @Test
    // @DisabledForE2E
    @Tag("fe")
    @Tag("e2e")
    public void limiterError() {
        loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.limiterError();
        boolean is = codeRequestPopup.isLimiterErrorMessage();
        assertTrue(is);
    }
}
