package com.vs.tp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class DownloadFilePopup extends BasePage{
    private final String DOWNLOAD_FILE_HEADER  = "//*[text() = 'Download File']";
    private final String COPY_LINK_BUTTON  = "//*[text() = 'Copy Link']";
    private final String START_DOWNLOAD_BUTTON  = "//*[text() = 'Start Download']";
    private final String TEXT  = "//*[text() = 'The file can be downloaded only once!']";
    private final String CHECK_BOX  = "//*[@type = 'checkbox']";
    private final String ADDHERE  = "";

    
    public String isDownloadHeaderVisible(){
        return findElementByXpath(DOWNLOAD_FILE_HEADER).getText();

    }

    public boolean checkBoxNotSelected() {
        WebElement checkBox = findElementByXpath(CHECK_BOX);
        if (!checkBox.isSelected()) {
            clickElementByXpath(START_DOWNLOAD_BUTTON);
            return elementExists(DOWNLOAD_FILE_HEADER);
        }
        return false;
    }
    public boolean checkBoxIsSelected() {
        WebElement checkBox = findElementByXpath(CHECK_BOX);
        checkBox.click();
        if (!checkBox.isSelected()) {
            clickElementByXpath(START_DOWNLOAD_BUTTON);
            return elementExists(DOWNLOAD_FILE_HEADER);
        }
        return false;
    }

    public String clipboard() throws IOException, UnsupportedFlavorException {
        webDriver.findElement(By.xpath(COPY_LINK_BUTTON));
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        return myText;
    }
}
