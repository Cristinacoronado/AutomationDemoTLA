package Tests;

import Base.BaseTest;
import Pages.CommonPage;
import Pages.HomePage;
import Pages.UserMgtPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class UserMgtPageTest extends BaseTest {
    UserMgtPage userMgtPage;
    CommonPage commonPage;

    @BeforeMethod
    public void setUp(Method method, ITestResult iTestResult){
        super.setUp(method, iTestResult);
        userMgtPage = new UserMgtPage(getDriver());
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
    }

    @Test(description = "Verifying title of User Management Page")
    public void verifyTitle(){
        Assert.assertEquals(getDriver().getTitle(), "Register New User");
        screenshot.takeScreenshotAndLog();
    }

    @Test(description = "Validating <Login> and <Access DB> buttons")
    public void verifyLoginAccessDB_buttons(){
        Assert.assertTrue(userMgtPage.accessDbBtn.isDisplayed());
        Assert.assertTrue(userMgtPage.loginBtn.isDisplayed());
        screenshot.takeScreenshotAndLog();
    }

    @Test(description = "Testing Registration Form fields")
    public void verifyRgtForm(){
        for (String field: userMgtPage.registrationFormFields){
            Assert.assertTrue(commonPage.findById(field).isDisplayed());
            extentTest.log(LogStatus.PASS, commonPage.findById(field).getAttribute("name") + " - was displayed");
        }
        screenshot.takeScreenshotAndLog();
    }

    @Test(description = "Verifying table has no data initially", expectedExceptions = NoSuchElementException.class)
    public void verifyTableContentIsZero(){
        extentTest.log(LogStatus.PASS, " Table was Empty");
        screenshot.takeScreenshotAndLog();
        userMgtPage.tableRow.isDisplayed();
    }
}