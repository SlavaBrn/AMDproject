package com.vs.tp.qa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.CodeRequestPopupPage;
import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.SuccessPopupPage;
import com.vs.tp.qa.utils.UseCaseBase;

public class SuccessPopupSuccessPopupTest extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopupPage codeRequestPopup;
    public static SuccessPopupPage successPopupPage;


    @BeforeAll
    public static void pageSetup() {
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopupPage();
        loginPage = new LoginPage();
        successPopupPage = new SuccessPopupPage();
    }

    @BeforeEach
    public void Each() {
        LoginPage.navigateLoginPage();
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.openSuccessPopup();
    }
    
    @Test
    public void continueToFewpromPage(){
        fewPromPage = successPopupPage.returnToFewPromPage();
        boolean is = fewPromPage.isLogOutButtonVisible();
        assertTrue(is);
    }
}
