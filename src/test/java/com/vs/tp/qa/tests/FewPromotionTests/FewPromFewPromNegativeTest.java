package com.vs.tp.qa.tests.FewPromotionTests;

import com.vs.tp.qa.pages.CodeRequestPopupPage;
import com.vs.tp.qa.pages.FewPromPage;
import com.vs.tp.qa.pages.LoginPage;
import com.vs.tp.qa.pages.SuccessPopupPage;
import com.vs.tp.qa.utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FewPromFewPromNegativeTest extends UseCaseBase {

    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopupPage codeRequestPopup;
    public static SuccessPopupPage successPopupPage;

    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        codeRequestPopup = new CodeRequestPopupPage();
        successPopupPage = new SuccessPopupPage();
        fewPromPage = new FewPromPage();
    }


    @BeforeEach
    public void beforeEach() {
        fewPromPage = loginPage.openFewPromPage();

    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void NoLoadPage(int id) {
        //codeRequestPopup = fewPromPage.openCodeRequestPage();
        fewPromPage.promotionLock(id);
        boolean visible = fewPromPage.isLogOutButtonVisible();
        assertTrue(visible);
    }
}
