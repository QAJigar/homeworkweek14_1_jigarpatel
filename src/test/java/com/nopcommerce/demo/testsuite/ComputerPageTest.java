package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        //Click on Computer tab
        homePage.clickOnComputerTab();
        //Verify "Computer" text
        Assert.assertEquals(computerPage.getComputerText(), "Computers", "Computer text is not matched");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //Click on Computer tab
        homePage.clickOnComputerTab();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Verify "Desktops" text
        Assert.assertEquals(desktopsPage.getDeskTopsText(), "Desktops", "Desktops text is not displayed");
    }

    @Test(groups = {"regression"}, dataProvider = "buildYouOwnComputer", dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        //Click on Computer tab
        homePage.clickOnComputerTab();
        //Click on Desktops link
        computerPage.clickOnDesktopsLink();
        //Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();
        //Select processor "processor"
        buildYourOwnComputerPage.selectOptionFromProcessorDropDown(processor);
        //Select RAM "ram"
        buildYourOwnComputerPage.selectOptionFromRamDropDown(ram);
        //Select HDD "hdd"
        buildYourOwnComputerPage.selectHddOption(hdd);
        //Select OS "os"
        buildYourOwnComputerPage.selectOsOption(os);
        //Select Software "software"
        buildYourOwnComputerPage.selectSoftwareOption(software);
        //Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartButton();
        //Verify message "The product has been added to your shopping cart"
        Assert.assertTrue(buildYourOwnComputerPage.getNotificationMessage().contains("The product has been added to your shopping cart"), "notification text is not matched");
    }
}
