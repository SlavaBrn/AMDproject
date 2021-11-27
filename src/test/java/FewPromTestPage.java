import Pages.CodeRequestPopup;
import Pages.FewPromPage;
import Pages.LoginPage;
import Util.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class FewPromTestPage extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopup codeRequestPopup;

    @BeforeAll
    public static void pageSetup() {
        loginPage = new LoginPage();
        codeRequestPopup = new CodeRequestPopup();
    }

    @BeforeEach
    public void beforeEach() {
        loginPage.navigateLoginPage();
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
}
