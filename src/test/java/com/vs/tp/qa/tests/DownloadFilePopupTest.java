package com.vs.tp.qa.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import com.vs.tp.qa.general.Const;
import com.vs.tp.qa.pages.CodeRequestPopup;
import com.vs.tp.qa.pages.DownloadFilePopup;
import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.SuccessPopup;
import com.vs.tp.qa.utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.*;

public class DownloadFilePopupTest extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopup codeRequestPopup;
    public static SuccessPopup successPopup;
    public static DownloadFilePopup downloadFilePopup;
    public static String COPY_LINK_BUTTON  = "//*[text() = 'Copy Link']";

    @BeforeAll
    public static void pageSetup() {

        loginPage = new LoginPage();
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopup();
        successPopup = new SuccessPopup();
        downloadFilePopup = new DownloadFilePopup();
    }

    @BeforeEach
    public void Each() {
        LoginPage.navigateLoginPage();
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.openSuccessPopup();
        successPopup.returnToFewPromPage();
        fewPromPage.openDownloadFilePopup();
    }

    @Test
    public void checkBoxNotSelected() {
        boolean is = downloadFilePopup.checkBoxNotSelected();
        assertTrue(is);
    }

    @Test
    public void checkBoxIsSelected() {
        boolean is = downloadFilePopup.checkBoxIsSelected();
        assertFalse(is);
    }
//    ClipBoard check
    @Test
    public void clipboardCheck() throws IOException, UnsupportedFlavorException {
        downloadFilePopup.checkBoxIsSelected();
        downloadFilePopup.clickElementByXpath(COPY_LINK_BUTTON);
        String isString = downloadFilePopup.clipboard();
        assertEquals(Const.BASE_URL + "/test.zip", isString);
    }
}