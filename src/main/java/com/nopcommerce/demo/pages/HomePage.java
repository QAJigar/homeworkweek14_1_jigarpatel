package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Computers")
    WebElement computerTab;

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(linkText = "Log out")
    WebElement logOutLink;

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
        Reporter.log("Click on login link" + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on login link");
    }

    public String getLogOutText() {
        Reporter.log("Get logout text" + logOutLink.toString());
        CustomListeners.test.log(Status.PASS, "get logout text");
        return getTextFromElement(logOutLink);
    }

    public String getLoginText() {
        Reporter.log("Get login text" + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "get login text");
        return getTextFromElement(loginLink);
    }

    public void clickOnLogoutLink() {
        clickOnElement(logOutLink);
        Reporter.log("Click on logout link" + logOutLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on logout link");
    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        Reporter.log("Click on register link" + registerLink.toString());
        CustomListeners.test.log(Status.PASS, "Click on register link");
    }

    public void clickOnComputerTab() {
        clickOnElement(computerTab);
        Reporter.log("Click on computer tab" + computerTab.toString());
        CustomListeners.test.log(Status.PASS, "Click on computer tab");
    }
}
