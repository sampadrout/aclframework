package tests;

import org.aclframework.allureReport.TestListener;
import org.aclframework.pageObjects.HomePage;
import org.aclframework.pageObjects.SignInPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({TestListener.class})
public class HomePageTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "testing the agent home page")
    public void testSignInOption() throws Exception {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.chooseSignInOption();
        softAssert.assertTrue(signInPage.verifySigninPageTitle().equals("Cinch Home Services - Agent"), "agent sign screen not displayed");
        softAssert.assertAll();
    }

}