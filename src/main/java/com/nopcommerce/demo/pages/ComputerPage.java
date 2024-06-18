package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//li[@class='inactive']//a[normalize-space()='Desktops']")
    WebElement desktopsLink;

    public String getComputerText() {
        Reporter.log("Get computer text" + computerText.toString());
        CustomListeners.test.log(Status.PASS, "Get computer text");
        return getTextFromElement(computerText);
    }

    public void clickOnDesktopsLink() {
        clickOnElement(desktopsLink);
        Reporter.log("click on desktops link" + desktopsLink.toString());
        CustomListeners.test.log(Status.PASS, "click on desktops link");
    }
}
