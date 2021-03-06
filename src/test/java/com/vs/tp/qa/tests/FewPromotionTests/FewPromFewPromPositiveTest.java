package com.vs.tp.qa.tests.FewPromotionTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import com.vs.tp.qa.pages.CodeRequestPopupPage;
import com.vs.tp.qa.pages.DownloadFilePopupPage;
import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.SuccessPopupPage;
import com.vs.tp.qa.utils.UseCaseBase;

public class FewPromFewPromPositiveTest extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopupPage codeRequestPopup;
    public static SuccessPopupPage successPopupPage;


    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        codeRequestPopup = new CodeRequestPopupPage();
        successPopupPage = new SuccessPopupPage();
    }

    @BeforeEach
    public void beforeEach() {
        fewPromPage = loginPage.openFewPromPage();
    }



    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    public void newPopup(int id) {
        //codeRequestPopup = fewPromPage.openCodeRequestPage();
        fewPromPage.promotionLock(id);
        boolean visible = codeRequestPopup.isVisible();
        assertTrue(visible);

    }

    @Test
    public void englishLanguageHeadersCheck() {
        String is = fewPromPage.promotionHeaderCheck();
        assertEquals("Promotion", is);
        String is1 = fewPromPage.expirationHeaderCheck();
        assertEquals("Expiration", is1);
        String is2 = fewPromPage.statusHeaderCheck();
        assertEquals("Status", is2);
    }

    @Test
    public void russianLanguageHeadersCheck() {
        String is = fewPromPage.promotionHeaderCheckRu();
        assertEquals("Название акции", is);
        String is1 = fewPromPage.expirationHeaderCheckRu();
        assertEquals("Дата окончания", is1);
        String is2 = fewPromPage.statusHeaderCheckRu();
        assertEquals("Статус", is2);
        String is3 = fewPromPage.logoutButtonLanguageCheckRu();
        assertEquals("Выйти", is3);
    }

    @Test
    public void statusesLanguageCheck() {
        String is = fewPromPage.activeLanguageCheck();
        assertEquals("Active", is);
        String is1 = fewPromPage.downloadedLanguageCheck();
        assertEquals("Downloaded", is1);
        String is2 = fewPromPage.expiredLanguageCheck();
        assertEquals("Expired", is2);
        String is3 = fewPromPage.deactivatedLanguageCheck();
        assertEquals("Deactivated", is3);
    }

    @Test
    public void statusesLanguageCheckRu() {
        String is = fewPromPage.activeLanguageCheckRu();
        assertEquals("Активная", is);
        String is1 = fewPromPage.downloadedLanguageCheckRu();
        assertEquals("Скачанная", is1);
        String is2 = fewPromPage.expiredLanguageCheckRu();
        assertEquals("Закончившаяся", is2);
        String is3 = fewPromPage.deactivatedLanguageCheckRu();
        assertEquals("Деактивированная", is3);

    }

    @Test
    public void downloadFilePopupCheck() {
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.openSuccessPopup();
        fewPromPage = successPopupPage.returnToFewPromPage();
        DownloadFilePopupPage downloadFilePopup = fewPromPage.openDownloadFilePopup();
        String is = downloadFilePopup.isDownloadHeaderVisible();
        assertEquals("Download File", is);
    }
    @Test
    public void logOutToLoginPage(){
        fewPromPage.logoutFromFewProm();
        boolean is = loginPage.IsLoginPageVisible();
        assertTrue(is);
    }


}
