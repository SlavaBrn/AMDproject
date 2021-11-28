package Pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class FewPromPage extends BasePage {
    private final String LANGUAGE_SELECTOR_EN = "//option[@value = 'EN']";
    private final String LANGUAGE_SELECTOR_RU = "//option[@value = 'RU']";
    private final String LANGUAGE_SELECTOR = "//*[@class = 'lang-selector']";
    public final String PROMOTION_COLUMN = "//span[text() = 'Promotion']";
    public final String EXPIRATION = "//span[text() = 'Expiration']";
    public final String STATUS = "//span[text() = 'Status']";
    public final String LOGOUT_LINK = "//span[text() = 'Logout']";
    public final String PROMOTION_COLUMN_RU = "//span[text() = 'Название акции']";
    public final String EXPIRATION_RU = "//span[text() = 'Дата окончания']";
    public final String STATUS_RU = "//span[text() = 'Статус']";
    public final String LOGOUT_LINK_RU = "//button[text() = 'Выйти']";


    private final String LOCK = "//*[@xmlns = 'http://www.w3.org/2000/svg']";
    private final String OPENED_LOCK = "//*[@xmlns = 'http://www.w3.org/2000/svg']";
    private final String OPENED_LOCK1 = "//svg[@fill = '#007C97']";
    private final String UNLOCK_REQUEST_HEADER = "//*[text() = 'Unlock Code Request']";
    private final String START_DOWNLOAD_BUTTON = "//*[text() = 'Start Download']";
    private final String DOWNLOAD_FILE_HEADER  = "//span[@id = 'overlay-window-header-caption']";

    private final String PROMOTION_ICON = "//span[text() = 'Promotion %d']";
    private final String LOGOUT_BUTTON = "//button[@id = 'logout-button']";
    private final String ACTIVE = "//span[text() = 'Active']";
    private final String DOWNLOADED = "//span[text() = 'Downloaded']";
    private final String Expired = "//span[text() = 'Expired']";
    private final String Deactivated = "//span[text() = 'Deactivated']";
    private final String ACTIVE_RU = "//span[text() = 'Активная']";
    private final String DOWNLOADED_RU = "//span[text() = 'Скачанная']";
    private final String Expired_RU = "//span[text() = 'Закончившаяся']";
    private final String Deactivated_RU = "//span[text() = 'Деактивированная']";
    private final String UNLOCK_REQUEST_HEADER_RU = "//*[text() = 'Запрос кода разблокировки']";


    public String isPromotion0Visible() {
        return findElementByXpath(PROMOTION_COLUMN).getText();
    }


    public boolean isLogOutButtonVisible() {
        boolean is = elementExists(LOGOUT_BUTTON);
        return is;
    }


    public CodeRequestPopup openCodeRequestPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_REQUEST_HEADER)));
        WebElement nameText = webDriver.findElement(By.xpath(ACTIVE));
        WebElement clickIt = webDriver.findElement(with(By.xpath(LOCK)).toRightOf(nameText));
        clickIt.click();
        return new CodeRequestPopup();
    }

    public CodeRequestPopup openCodeRequestPageForRussian() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_REQUEST_HEADER_RU)));
        WebElement nameText = webDriver.findElement(By.xpath(ACTIVE_RU));
        WebElement clickIt = webDriver.findElement(with(By.xpath(LOCK)).toRightOf(nameText));
        clickIt.click();
        return new CodeRequestPopup();
    }


    public void promotionLock(int num) {
        String path = String.format(PROMOTION_ICON, num);
        short_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        WebElement nameText = webDriver.findElement(By.xpath(path));
        webDriver.findElement(with(By.xpath(LOCK)).toRightOf(nameText)).click();
    }

//    Open DownloadFilePopup

        public DownloadFilePopup openDownloadFilePopup() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(START_DOWNLOAD_BUTTON)));
        WebElement nameText = webDriver.findElement(By.xpath(LOCK));
        WebElement clickIt = webDriver.findElement(with(By.xpath(OPENED_LOCK)).toRightOf(nameText));
        clickIt.click();
        return new DownloadFilePopup();
    }


    //English language promotion headers

    public String promotionHeaderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(PROMOTION_COLUMN).getText();
    }

    public String expirationHeaderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(EXPIRATION).getText();
    }

    public String statusHeaderCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);

        return findElementByXpath(STATUS).getText();
    }

    //    Russian Language promotion headers
    public void russianSelectorOption() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
    }

    public String promotionHeaderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(PROMOTION_COLUMN_RU).getText();
    }

    public String expirationHeaderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(EXPIRATION_RU).getText();
    }

    public String statusHeaderCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(STATUS_RU).getText();
    }

    public String logoutButtonLanguageCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(LOGOUT_LINK_RU).getText();
    }
//English statuses language check

    public String activeLanguageCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(ACTIVE).getText();
    }

    public String downloadedLanguageCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(DOWNLOADED).getText();
    }

    public String expiredLanguageCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(Expired).getText();
    }

    public String deactivatedLanguageCheck() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(Deactivated).getText();
    }

    //    Russian statuses Language check
    public String activeLanguageCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(ACTIVE_RU).getText();
    }

    public String downloadedLanguageCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(DOWNLOADED_RU).getText();
    }

    public String expiredLanguageCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(Expired_RU).getText();
    }

    public String deactivatedLanguageCheckRu() {
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_RU);
        return findElementByXpath(Deactivated_RU).getText();
    }


}