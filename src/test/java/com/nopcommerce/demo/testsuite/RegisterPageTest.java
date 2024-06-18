package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Verify "Register" text
        Assert.assertEquals(registerPage.getRegisterText(), "Register", "Register text is not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //Verify the error message "First name is required."
        Assert.assertEquals(registerPage.getFirstNameFieldErrorMessage(), "First name is required.", "error message is not displayed");
        //Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.getLastNameFieldErrorMessage(), "Last name is required.", "error message is displayed");
        //Verify the error message "Email is required."
        Assert.assertEquals(registerPage.getEmailFieldErrorMessage(), "Email is required.", "error message is displayed");
        //Verify the error message "Password is required."
        Assert.assertEquals(registerPage.getPasswordFieldErrorMessage(), "Password is required.", "error message is displayed");
        //Verify the error message "Password is required."
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        //Select gender "Female"
        registerPage.clickOnFemaleGenderRadioButton();
        //Enter firstname
        registerPage.enterTextToFirstName("Test FirstName");
        //Enter lastname
        registerPage.enterTextToLastName("Test LastName");
        //Select day
        registerPage.selectDayFromDateOfBirthDropdown("12");
        //Select month
        registerPage.selectMonthFromDateOfBirthDropdown("June");
        //Select year
        registerPage.selectYearFromDateOfBirthDropdown("1990");
        //Enter email
        registerPage.enterTextToEmail("testfnln+" + generateRandomNumber() + "@gmail.com");
        //Enter password
        registerPage.enterTextToPassword("test@123");
        //Enter Confirm Password
        registerPage.enterTextToConfirmPassword("test@123");
        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        //Verify message "Your registration completed"
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed", "registration is not successful");
    }
}
