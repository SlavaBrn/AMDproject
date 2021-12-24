package com.vs.tp.qa.tests.DownloadFilePopupTets;

import com.vs.tp.qa.pages.*;
import com.vs.tp.qa.utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class DownloadFilePopupDownloadFilePopupNegativeTest extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopupPage codeRequestPopup;
    public static SuccessPopupPage successPopupPage;
    public static DownloadFilePopupPage downloadFilePopup;

    @BeforeAll
    public static void pageSetup() {

        loginPage = new LoginPage();
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopupPage();
        successPopupPage = new SuccessPopupPage();
        downloadFilePopup = new DownloadFilePopupPage();
    }

    @BeforeEach
    public void Each() {
        LoginPage.navigateLoginPage();
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.openSuccessPopup();
        successPopupPage.returnToFewPromPage();
        fewPromPage.openDownloadFilePopup();
    }
}
