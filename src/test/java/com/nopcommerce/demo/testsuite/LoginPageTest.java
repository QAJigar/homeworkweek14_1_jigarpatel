package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        //Click on login link
        homePage.clickOnLoginLink();
        //verify that "Welcome, Please Sign In!" message display
        Assert.assertTrue(loginPage.getWelcomeText().contains("Welcome, Please Sign In!"), "Login page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterTextToEmail("prime1234@gmail.com");
        //Enter Password
        loginPage.enterTextToPassword("prime1234");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that the Error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage, "Error message not displayed");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterTextToEmail("prime123@gmail.com");
        //Enter Password
        loginPage.enterTextToPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Verify that LogOut link is display
        Assert.assertEquals(homePage.getLogOutText(), "Log out", "Logout link is not displayed ");

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() throws InterruptedException {
        //Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId
        loginPage.enterTextToEmail("prime123@gmail.com");
        //Enter Password
        loginPage.enterTextToPassword("prime123");
        //Click on Login Button
        loginPage.clickOnLoginButton();
        //Click on LogOut Link
        homePage.clickOnLogoutLink();
        Thread.sleep(5000);
        //Verify that LogIn Link Display
        Assert.assertEquals(homePage.getLoginText(), "Log in", "Log in text is not displayed");
    }
}
