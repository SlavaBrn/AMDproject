package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;
    protected static WebDriverWait shortWait;
    protected static WebDriverWait longWait;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);

    public void setDriver(WebDriver webDriver) {
        logger.error(System.getenv("TEST"));
        BasePage.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        shortWait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        longWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void clickElementByXpath(String xpath) {
        logger.info("click element with xpath" + xpath);
        findElementByXpath(xpath).click();
    }

    protected void locateElementByXpath(String xpath) {
        findElementByXpath(xpath);
    }

    public void sendKeysByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }

    public boolean elementExists(String xpath) {
        try {
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {
            logger.error("Error: " + err);
        }
        return false;
    }

    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void takesScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("screenshot/" + name + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
