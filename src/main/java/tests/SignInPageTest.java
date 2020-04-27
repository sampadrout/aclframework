package tests;

import org.aclframework.allureReport.TestListener;
import org.aclframework.pageObjects.DashboardPage;
import org.aclframework.pageObjects.SignInPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners({TestListener.class})
public class SignInPageTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "test valid technician signin")
    public void testValidSignIn() throws Exception {
        SignInPage signInPage = new SignInPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        signInPage.signIn("testr@cchs.com", "Abc123!@#");
        softAssert.assertTrue(dashboardPage.verifyTodayJobTabDisplayed(), "Signin failed. Dashboard page not displayed.");
        softAssert.assertAll();
    }

    @Test(description = "test invalid technician signin")
    public void testInvalidSign() throws Exception {
        SignInPage signInPage = new SignInPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        signInPage.signIn("testr@cchs.com", "Zz123456!");
        softAssert.assertTrue(dashboardPage.verifyLoginErrorMessage(), "Invalid signin attempt failed to display the error message");
        softAssert.assertAll();
    }
}