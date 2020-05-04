package tests;

import org.aclframework.allureReport.TestListener;
import org.aclframework.pageObjects.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

@Listeners({TestListener.class})
public class CreateCompanyTest extends BaseTest {

    Map<String, String> company_details = new HashMap<String, String>(){{
        put("companyname","A10 Company");
        put("address1","3627, Garnet Street");
        put("address2","Torrance Blvd");
        put("city","Torrance");
        put("state","California");
        put("zip","90503");
        put("phone","3104605656");
        put("email","test@test.com");
        put("ranking","Tier 1 Medium");
        put("techniciannos","100");
        put("reporingname","A10 Company");
        put("legalbusinessname","A10 Company");
        put("typeeofownership","Limited Liability Company");
        put("taxid","123-45-6789");
    }};

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "test create company")
    public void testCreateCompany() throws Exception {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        AdministrationPage administrationPage = new AdministrationPage(driver);
        ServiceProsPage serviceProsPage = new ServiceProsPage(driver);
        CompanyDetailsPage companyDetailsPage = new CompanyDetailsPage(driver);
        CoveragePage coveragePage = new CoveragePage(driver);
//        ItemsAndBrandsPage itemsAndBrandsPage = new ItemsAndBrandsPage(driver);
//        LaborRatesPage laborRatesPage = new LaborRatesPage(driver);
//        AvailabilityPage availabilityPage = new AvailabilityPage(driver);

        homePage.chooseSignInOption();
        signInPage.signIn("srout", "Zz123456!");
        dashboardPage.navigateToTab("Administration");
        administrationPage.goToLink("Service Pros");
        serviceProsPage.createNewCompany();
        companyDetailsPage.enterCompanyDetails(company_details);
        coveragePage.gotoCoverageTab();
        coveragePage.enterCoverageDetails();
//        itemsAndBrandsPage.enterItemsAndBrandDetails();
//        laborRatesPage.enterLaborRatesDetails();
//        availabilityPage.enterAvailabilityDetails();
//        softAssert.assertTrue(serviceProsPage.searchServicePros(), "");
        softAssert.assertAll();
    }
}