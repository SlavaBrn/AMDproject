package Util;

import Pages.BasePage;
import org.junit.jupiter.api.*;



import org.openqa.selenium.WebDriver;


public class UseCaseBase {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = ShareDriver.getWebDriver(ShareDriver.Browser.CHROME);
        page.setDriver(webDriver);
    }

    @AfterAll
    public static void tearDownMain() {
        ShareDriver.closeDriver();
    }
}
