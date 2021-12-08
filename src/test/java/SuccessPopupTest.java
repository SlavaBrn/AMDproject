import Pages.CodeRequestPopup;
import Pages.FewPromPage;
import Pages.LoginPage;
import Pages.SuccessPopup;
import Util.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SuccessPopupTest extends UseCaseBase {
    public static FewPromPage fewPromPage;
    public static LoginPage loginPage;
    public static CodeRequestPopup codeRequestPopup;
    public static SuccessPopup successPopup;


    @BeforeAll
    public static void pageSetup() {
        fewPromPage = new FewPromPage();
        codeRequestPopup = new CodeRequestPopup();
        loginPage = new LoginPage();
        successPopup = new SuccessPopup();
    }

    @BeforeEach
    public void Each() {
        LoginPage.navigateLoginPage();
        fewPromPage = loginPage.openFewPromPage();
        fewPromPage.openCodeRequestPage();
        codeRequestPopup.openSuccessPopup();
    }
    
    @Test
    public void continueToFewpromPage(){
        fewPromPage = successPopup.returnToFewPromPage();
        boolean is = fewPromPage.isLogOutButtonVisible();
        assertTrue(is);
    }
}
