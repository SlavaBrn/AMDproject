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
    public final String PROMOTION0 = "//span[text() = 'Promotion 0']";
    public final String PROMOTION_COLUMN = "//span[text() = 'Promotion']";
    public final String EXPIRATION = "//span[text() = 'Expiration']";
    public final String STATUS = "//span[text() = 'Status']";
    public final String LOGOUT_LINK = "//span[text() = 'Logout']";
    public final String PROMOTION_COLUMN_RU = "//span[text() = 'Promotion']";
    public final String EXPIRATION_RU = "//span[text() = 'Expiration']";
    public final String STATUS_RU = "//span[text() = 'Status']";


    private final String ACTIVE = "//span[text() = 'Active']";
    private final String LOCK = "//*[@xmlns = 'http://www.w3.org/2000/svg']";
    private final String UNLOCK_REQUEST_HEADER = "//*[text() = 'Unlock Code Request']";
    private final String PROMOTION_ICON = "//span[text() = 'Promotion %d']";
    private final String LOGOUT_BUTTON = "//button[@id = 'logout-button']";


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

    public void promotionLock(int num) {
        String path = String.format(PROMOTION_ICON, num);
        short_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        WebElement nameText = webDriver.findElement(By.xpath(path));
        webDriver.findElement(with(By.xpath(LOCK)).toRightOf(nameText)).click();

    }
    public String promotionHeaderCheck(){
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(PROMOTION_COLUMN).getText();
    }
    public String ExpirationHeaderCheck(){
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(EXPIRATION).getText();
    }
    public String statusHeaderCheck(){
        clickElementByXpath(LANGUAGE_SELECTOR);
        clickElementByXpath(LANGUAGE_SELECTOR_EN);
        return findElementByXpath(PROMOTION_COLUMN).getText();
    }



}