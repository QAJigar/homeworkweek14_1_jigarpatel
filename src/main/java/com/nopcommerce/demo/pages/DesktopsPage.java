package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement desktopText;

    @CacheLookup
    @FindBy(linkText = "Build your own computer")
    WebElement buildYourOwnComputer;

    public String getDeskTopsText() {
        Reporter.log("Get desktops text" + desktopText.toString());
        CustomListeners.test.log(Status.PASS, "Get desktops text");
        return getTextFromElement(desktopText);
    }

    public void clickOnBuildYourOwnComputer() {
        clickOnElement(buildYourOwnComputer);
        Reporter.log("click on build your own computer product" + buildYourOwnComputer.toString());
        CustomListeners.test.log(Status.PASS, "click on build your own computer product");
    }
}
