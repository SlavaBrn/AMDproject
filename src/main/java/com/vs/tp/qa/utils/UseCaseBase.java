package com.vs.tp.qa.utils;

import com.vs.tp.qa.general.Const;
import com.vs.tp.qa.pages.BasePage;

import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;


public class UseCaseBase {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = ShareDriver.getWebDriver(Const.BROWSER);
        page.setDriver(webDriver);
    }

    @AfterAll
    public static void tearDownMain() {
        ShareDriver.closeDriver();
    }
}
