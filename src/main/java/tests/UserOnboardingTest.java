package tests;

import org.aclframework.allureReport.TestListener;
import org.aclframework.pageObjects.DashboardPage;
import org.aclframework.pageObjects.HomePage;
import org.aclframework.pageObjects.UserRegistration;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

@Listeners({TestListener.class})
public class UserOnboardingTest extends BaseTest {

    Map<String, String> user_details = new HashMap<String, String>(){{
        put("companyid","804");
        put("emailaddress","autotest@mail.com");
        put("firstname","Automation");
        put("lastname","User");
        put("enterpassword","Aa123456!");
        put("reenterpassword","Aa123456!");
    }};

    SoftAssert softAssert = new SoftAssert();
    
    @Test(description = "This is the test for user onboarding")
    public void testUserOnboarding() throws Exception {
        HomePage homePage = new HomePage(driver);
        UserRegistration userRegistration = new UserRegistration(driver);

        homePage.chooseUserRegistration();
        userRegistration.completeUserRegistration(user_details);
        softAssert.assertTrue(userRegistration.accountCreationTextDisplayed(), "User onboarding failed");
        userRegistration.navigateToSPLogin();
        softAssert.assertAll();
    }
}