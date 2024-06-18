package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(className = "login-button")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    public void enterTextToEmail(String emailText) {
        sendTextToElement(email, emailText);
        Reporter.log("Enter email " + emailText + " to email field" + email.toString());
        CustomListeners.test.log(Status.PASS, "Enter email " + emailText + " to email field");
    }

    public void enterTextToPassword(String passwordText) {
        sendTextToElement(password, passwordText);
        Reporter.log("Enter email " + passwordText + " to email field" + password.toString());
        CustomListeners.test.log(Status.PASS, "Enter email " + passwordText + " to email field");
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("Click on login button" + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on login button");
    }

    public String getWelcomeText() {
        Reporter.log("Get welcome text" + welcomeText.getText());
        CustomListeners.test.log(Status.PASS, "Get welcome text message");
        return getTextFromElement(welcomeText);
    }

    public String getErrorMessageText() {
        Reporter.log("Get error message" + errorMessage.getText());
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(errorMessage);
    }
}
