package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "gender-male")
    WebElement maleRadio;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement femaleRadio;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;

    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement dayFromDateOfBirthDropdown;

    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    WebElement monthFromDateOfBirthDropdown;

    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement yearFromDateOfBirthDropdown;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;

    @CacheLookup
    @FindBy(id = "FirstName-error")
    WebElement firstNameFieldErrorMessage;

    @CacheLookup
    @FindBy(id = "LastName-error")
    WebElement lastNameFieldErrorMessage;

    @CacheLookup
    @FindBy(id = "Email-error")
    WebElement emailFieldErrorMessage;

    @CacheLookup
    @FindBy(id = "ConfirmPassword-error")
    WebElement passwordFieldErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement successfulRegistrationMessage;


    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    public String getRegisterText() {
        Reporter.log("Get register text" + registerText.toString());
        CustomListeners.test.log(Status.PASS, "Get register text");
        return getTextFromElement(registerText);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
        Reporter.log("Click on register button" + registerButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on register button");
    }

    public String getFirstNameFieldErrorMessage() {
        Reporter.log("Get firstname field error message" + firstNameFieldErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get firstname field error message");
        return getTextFromElement(firstNameFieldErrorMessage);
    }

    public String getLastNameFieldErrorMessage() {
        Reporter.log("Get lastname field error message" + lastNameFieldErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get firstname field error message");
        return getTextFromElement(lastNameFieldErrorMessage);
    }

    public String getEmailFieldErrorMessage() {
        Reporter.log("Get email field error message" + emailFieldErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get firstname field error message");
        return getTextFromElement(emailFieldErrorMessage);
    }

    public String getPasswordFieldErrorMessage() {
        Reporter.log("Get password field error message" + passwordFieldErrorMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get firstname field error message");
        return getTextFromElement(passwordFieldErrorMessage);
    }

    public void clickOnFemaleGenderRadioButton() {
        clickOnElement(femaleRadio);
        Reporter.log("Click on Female option from Gender radio button" + femaleRadio.toString());
        CustomListeners.test.log(Status.PASS, "Click on Female option from Gender radio button");
    }

    public void enterTextToFirstName(String firstnameText) {
        sendTextToElement(firstName, firstnameText);
        Reporter.log("Enter firstname" + firstnameText + " to firstname field" + firstName.toString());
        CustomListeners.test.log(Status.PASS, "Enter firstname" + firstnameText + " to firstname field");
    }

    public void enterTextToLastName(String lastnameText) {
        sendTextToElement(lastName, lastnameText);
        Reporter.log("Enter lastname " + lastnameText + " to lastname field" + lastName.toString());
        CustomListeners.test.log(Status.PASS, "Enter lastname " + lastnameText + " to lastname field");
    }

    public void selectDayFromDateOfBirthDropdown(String dayValue) {
        selectByVisibleTextFromDropDown(dayFromDateOfBirthDropdown, dayValue);
        Reporter.log("Select day value '" + dayValue + "' from Date of birth dropdown" + dayFromDateOfBirthDropdown.toString());
        CustomListeners.test.log(Status.PASS, "Select day value '" + dayValue + "' from Date of birth dropdown");
    }

    public void selectMonthFromDateOfBirthDropdown(String monthValue) {
        selectByVisibleTextFromDropDown(monthFromDateOfBirthDropdown, monthValue);
        Reporter.log("Select month value '" + monthValue + "' from Date of birth dropdown" + monthFromDateOfBirthDropdown.toString());
        CustomListeners.test.log(Status.PASS, "Select month value '" + monthValue + "' from Date of birth dropdown");
    }

    public void selectYearFromDateOfBirthDropdown(String yearValue) {
        selectByVisibleTextFromDropDown(yearFromDateOfBirthDropdown, yearValue);
        Reporter.log("Select year value '" + yearValue + "' from Date of birth dropdown" + yearFromDateOfBirthDropdown.toString());
        CustomListeners.test.log(Status.PASS, "Select year value '" + yearValue + "' from Date of birth dropdown");
    }

    public void enterTextToEmail(String emailText) {
        sendTextToElement(email, emailText);
        Reporter.log("Enter email" + emailText + " to email field" + email.toString());
        CustomListeners.test.log(Status.PASS, "Enter email " + emailText + " to email field");
    }

    public void enterTextToPassword(String passwordText) {
        sendTextToElement(password, passwordText);
        Reporter.log("Enter password '" + passwordText + "' to password field" + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter password '" + passwordText + "' to password field");
    }

    public void enterTextToConfirmPassword(String confirmPasswordText) {
        sendTextToElement(confirmPassword, confirmPasswordText);
        Reporter.log("Enter confirm password '" + confirmPasswordText + "' to password field" + confirmPassword.toString());
        CustomListeners.test.log(Status.PASS, "Enter confirm password '" + confirmPasswordText + "' to password field");
    }

    public String getRegisterSuccessMessage() {
        Reporter.log("Get registration successful message" + successfulRegistrationMessage.toString());
        CustomListeners.test.log(Status.PASS, "Get registration successful message");
        return getTextFromElement(successfulRegistrationMessage);
    }
}
