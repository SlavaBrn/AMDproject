import Pages.CodeRequestPopup;
import Pages.FewPromPage;
import Pages.LoginPage;
import Util.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class CodeRequestPopupTest extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopup codeRequestPopup;

    @BeforeAll
    public static void pageSetup() {
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopup();
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void Each() {
        loginPage.navigateLoginPage();
        fewPromPage = loginPage.openFewPromPage();


    }
    //    Unlock Code Request popup elements language check

    @Test
    public void popupPageLanguageCheck() {
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.isVisible();
        assertTrue(is);
    }

    @Test
    public void popupPageLanguageCheck1() {
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.isTextVisible();
        assertTrue(is);
    }


    @Test
    public void popupPageLanguageCheck2() {
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.isPlaceholderVisible();
        assertTrue(is);
    }

    @Test
    public void popupPageLanguageCheck3() {
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.isRequestVisible();
        assertTrue(is);
    }


    @Test
    public void popupPageLanguageCheck4() {
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.isSubmitButtonVisible();
        assertTrue(is);
    }

    @Test
    public void popupPageLanguageCheck5() {
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.isCancelButtonVisible();
        assertTrue(is);
    }

    //    Unlock Code Request popup elements language check Russian

    @Test
    public void popupPageLanguageCheckRu() {
        fewPromPage.russianSelectorOption();
        fewPromPage.openCodeRequestPageForRussian();
        boolean is = codeRequestPopup.isVisibleRu();
        assertTrue(is);
    }

    @Test
    public void popupPageLanguageCheck1Ru() {
        fewPromPage.russianSelectorOption();
        fewPromPage.openCodeRequestPageForRussian();
        boolean is = codeRequestPopup.isTextVisibleRu();
        assertTrue(is);
    }

    @Test
    public void popupPageLanguageCheck2Ru() {
        fewPromPage.russianSelectorOption();
        fewPromPage.openCodeRequestPageForRussian();
        boolean is = codeRequestPopup.isPlaceholderVisibleRu();
        assertTrue(is);
    }

    @Test
    public void popupPageLanguageCheck3Ru() {
        fewPromPage.russianSelectorOption();
        fewPromPage.openCodeRequestPageForRussian();
        boolean is = codeRequestPopup.isRequestVisibleRu();
        assertTrue(is);
    }



    @Test
    public void popupPageLanguageCheck5Ru() {
        fewPromPage.russianSelectorOption();
        fewPromPage.openCodeRequestPageForRussian();
        boolean is = codeRequestPopup.isSubmitButtonVisibleRu();
        assertTrue(is);
    }

//    @Test
//    public void popupPageLanguageCheck6Ru() {
//        fewPromPage.russianSelectorOption();
//        fewPromPage.openCodeRequestPageForRussian();
//        boolean is = codeRequestPopup.isC();
//        assertTrue(is);
//    }

//    Buttons Actions

    @Test
    public void sendRequestButtonPress(){
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.requestUnlockButtonPressMessage();
        assertTrue(is);
    }
    @Test
    public void resendRequestButtonPress(){
        fewPromPage.openCodeRequestPage();
        boolean is = codeRequestPopup.resendUnlockButtonPressMessage();
        assertTrue(is);
    }
    @Test
    public void CancelButtonPress(){
        fewPromPage.openCodeRequestPage();
        FewPromPage fewPromPage = codeRequestPopup.pressCancelButton();
        boolean is = fewPromPage.isLogOutButtonVisible();
        assertTrue(is);
    }

}
