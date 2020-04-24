package tests;

import org.aclframework.allureReport.TestListener;
import org.aclframework.pageObjects.DashboardPage;
import org.aclframework.pageObjects.SignInPage;
import org.aclframework.pageObjects.HomePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({TestListener.class})
public class SignInPageTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "test valid agent signin")
    public void testValidSignIn() throws Exception {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        homePage.chooseSignInOption();
        signInPage.signIn("srout", "Zz123456!");
        softAssert.assertTrue(dashboardPage.verifyDashboardPageDisplayed(), "Signin failed. Dashboard page not displayed.");
        softAssert.assertAll();
    }

    @Test(description = "test invalid agent signin")
    public void testInvalidSign() throws Exception {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        homePage.chooseSignInOption();
        signInPage.signIn("srout", "1234");
        softAssert.assertTrue(dashboardPage.verifyloginErrorMessage(), "Invalid signin attempt failed to display the error message");
        softAssert.assertAll();
    }
}