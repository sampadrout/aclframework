package tests;

import org.aclframework.allureReport.TestListener;
import org.aclframework.pageObjects.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

@Listeners({TestListener.class})
public class UserOnboardingTest extends BaseTest {

    Map<String, String> account_details = new HashMap<String, String>(){{
        put("typeeofownership", "Limited Liability Company");
    }};

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "This is the test for user onboarding")
    public void testUserOnboarding() throws Exception {

        String query = "SELECT * FROM sp.company_details";
        List<Map<String, String>> user_details = dbUtil.getTestDataList(query);

        HomePage homePage = new HomePage(driver);
        CompleteUserCreation completeAccountCreation = new CompleteUserCreation(driver);
        SignInPage signInPage = new SignInPage(driver);
        AccountSetupWizard accountSetupWizard = new AccountSetupWizard(driver);
        CompanyInfo companyInfo = new CompanyInfo(driver);
        Coverage coverage = new Coverage(driver);
        TradesAndItems tradesAndItems = new TradesAndItems(driver);
        LaborRates laborRates = new LaborRates(driver);
        Availability availability = new Availability(driver);
        ServiceRequestPage serviceRequestPage = new ServiceRequestPage(driver);

        homePage.chooseUserRegistration();
        completeAccountCreation.completeUserCreation(user_details);
        softAssert.assertTrue(completeAccountCreation.accountCreationTextDisplayed(), "User onboarding failed");
        completeAccountCreation.navigateToSPLogin();
        homePage.chooseSignInOption();
        signInPage.signIn(user_details);
        softAssert.assertTrue(accountSetupWizard.verifyAccSetupWizardPageDisplayed(), "New user signin to SP failed");
        companyInfo.enterCompanyDetails(account_details);
        coverage.enterCoverageDetails();
        tradesAndItems.enterTradeAndItemsDetails();
        laborRates.enterLaborRatesDetails();
        availability.enterAvailabilityDetails();
        softAssert.assertTrue(serviceRequestPage.verifyServiceRequestPageDisplayed(), "User Registration failed");
        softAssert.assertAll();
    }
}