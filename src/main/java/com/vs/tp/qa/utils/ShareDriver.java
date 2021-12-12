package com.vs.tp.qa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;
import com.vs.tp.qa.general.Const;


public class ShareDriver {
    public static WebDriver webDriver;

    protected static WebDriver getWebDriver(String browser) {

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                if (Const.IS_HEADLESS) {
                    ffOptions.addArguments("-headless");
                }
                webDriver = new FirefoxDriver(ffOptions);
            break;

            default:
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Const.IS_HEADLESS) {
                    chromeOptions.addArguments("--headless");
                }
                webDriver = new ChromeDriver(chromeOptions);
                break;
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return webDriver;
    }

    protected static void closeDriver() {
        if (webDriver != null) {
            webDriver.close();
        }

    }
}

