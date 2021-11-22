package Pages;

public class CodeRequestPopup extends BasePage {
    private final String unlock = "//*[text() = 'Unlock Code Request']";

    public boolean isVisible() {
        return elementExists(unlock);
    }

    public String isVisible1() {
        return findElementByXpath(unlock).getText();
    }

}
