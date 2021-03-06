package com.vs.tp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CodeRequestPopupPage extends BasePage {
    private final String unlock = "//*[text() = 'Unlock Code Request']";

    private final String GREETING_TEXT = "//*[text() = 'In order to download this file you need to unlock it first.']";
    public static String UNLOCK_FIELD = "//*[@class = 'popup-window-input-field']";
    private final String UNLOCK_PLACEHOLDER = "//*[@placeholder = 'Enter Unlock Code']";
    private final String UNLOCK_REQUEST = "//*[text() = 'Request Unlock Code']";
    private final String SUBMIT_CODE_BUTTON = "//input[@type = 'submit']";
    private final String CANCEL_BUTTON = "//button[text() = 'Cancel']";

    private final String unlock_ru = "//span[text() = 'Запрос кода разблокировки']";
    private final String GREETING_TEXT_RU = "//*[text() = 'Для скачивания файла необходима разблокировка.']";
    private final String UNLOCK_FIELD_RU = "//*[@class = 'popup-window-input-field']";
    private final String UNLOCK_PLACEHOLDER_RU = "//*[@placeholder = 'Введите Код Разблокировки']";
    private final String UNLOCK_REQUEST_RU = "//*[text() = 'Запросить код']";
    private final String SUBMIT_CODE_BUTTON_RU = "//input[@value = 'Отправить код']";
//    private final String CANCEL_BUTTON_RU = "//button[text() = 'Cancel']";

    //    For Buttons actions
    private final String UNLOCK_SENT_MESSAGE = "//*[text() = 'Unlock code was sent to your email.']";
    private final String RESEND_UNLOCK_BUTTON = "//*[text() = 'Resend Unlock Code']";

    //    Codes
    private final String SUCCESS_CODE_INPUT = "200000";
    private final String FAIL_CODE_INPUT = "23456778";
    private final String FAIL_SERVER_INPUT = "500000";
    private final String UNKNOWN_ERROR_INPUT = "400000 ";
    private final String LIMITER_ERROR_INPUT = "429000 ";
    private final String NOT_VALID_MESSAGE = "//div[text() = 'Please, enter a valid 6-digit code']";
    private final String SERVER_FAILED_MESSAGE = "//div[text() = 'Request ID: req500']";
    private final String UNKNOWN_ERROR_MESSAGE = "//div[text() = 'Request ID: req400']";
    private final String LIMITER_ERROR_MESSAGE = "//div[text() = 'Too many attempts.']";


    //     Unlock Code Request popup elements language check

    public boolean isVisible() {
        return elementExists(unlock);
    }

    public boolean isTextVisible() {
        return elementExists(GREETING_TEXT);
    }

    public boolean isPlaceholderVisible() {
        return elementExists(UNLOCK_PLACEHOLDER);
    }

    public boolean isRequestVisible() {
        return elementExists(UNLOCK_REQUEST);
    }

    public boolean isSubmitButtonVisible() {
        return elementExists(SUBMIT_CODE_BUTTON);
    }

    public boolean isCancelButtonVisible() {
        return elementExists(CANCEL_BUTTON);
    }

    //    Unlock Code Request popup elements language check Russian
    public boolean isVisibleRu() {
        return elementExists(unlock_ru);
    }

    public boolean isTextVisibleRu() {
        return elementExists(GREETING_TEXT_RU);
    }

    public boolean isPlaceholderVisibleRu() {
        return elementExists(UNLOCK_PLACEHOLDER_RU);
    }

    public boolean isRequestVisibleRu() {
        return elementExists(UNLOCK_REQUEST_RU);
    }

    public boolean isSubmitButtonVisibleRu() {
        return elementExists(SUBMIT_CODE_BUTTON_RU);
    }

//    public boolean isCancelButtonVisibleRu() {
//        return elementExists(CANCEL_BUTTON);
//    }


    //Actions with buttons


    public boolean requestUnlockButtonPressMessage() {
        clickElementByXpath(UNLOCK_REQUEST);
        return elementExists(UNLOCK_SENT_MESSAGE);
    }

    public boolean resendUnlockButtonPressMessage() {
        clickElementByXpath(UNLOCK_REQUEST);
        longWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_SENT_MESSAGE)));
        clickElementByXpath(RESEND_UNLOCK_BUTTON);
        return elementExists(UNLOCK_SENT_MESSAGE);
    }

    public FewPromPage pressCancelButton() {
        clickElementByXpath(CANCEL_BUTTON);
        return new FewPromPage();

    }

//    ---------------- Unlock Popup (Code Submit)------------------------


    //    Unlock Popup (code submit)
    public SuccessPopupPage openSuccessPopup() {
        clickElementByXpath(UNLOCK_REQUEST);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_SENT_MESSAGE)));
        sendKeysByXpath(UNLOCK_FIELD, SUCCESS_CODE_INPUT);
        clickElementByXpath(SUBMIT_CODE_BUTTON);
        return new SuccessPopupPage();
    }

    public void codeFail() {
        clickElementByXpath(UNLOCK_REQUEST);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_SENT_MESSAGE)));
        sendKeysByXpath(UNLOCK_FIELD, FAIL_CODE_INPUT);
        clickElementByXpath(SUBMIT_CODE_BUTTON);
    }

    public boolean isFailMessage() {
        return elementExists(NOT_VALID_MESSAGE);

    }

    public void serverFail() {
        clickElementByXpath(UNLOCK_REQUEST);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_SENT_MESSAGE)));
        sendKeysByXpath(UNLOCK_FIELD, FAIL_SERVER_INPUT);
        clickElementByXpath(SUBMIT_CODE_BUTTON);
    }

    public boolean isServerFailMessage() {
        return elementExists(SERVER_FAILED_MESSAGE);
    }

    public void unknownError() {
        clickElementByXpath(UNLOCK_REQUEST);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_SENT_MESSAGE)));
        sendKeysByXpath(UNLOCK_FIELD, UNKNOWN_ERROR_INPUT);
        clickElementByXpath(SUBMIT_CODE_BUTTON);
    }

    public boolean isUnknownErrorMessage() {
        return elementExists(UNKNOWN_ERROR_MESSAGE);
    }
    public void limiterError() {
        clickElementByXpath(UNLOCK_REQUEST);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(UNLOCK_SENT_MESSAGE)));
        sendKeysByXpath(UNLOCK_FIELD, LIMITER_ERROR_INPUT);
        clickElementByXpath(SUBMIT_CODE_BUTTON);
    }
    public boolean isLimiterErrorMessage() {
        return elementExists(LIMITER_ERROR_MESSAGE);
    }


}
