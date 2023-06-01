package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected LoginPage loginPage;
    protected MyAccount myAccount;
    protected DriverFactory driverFactory;
    protected SearchResult searchResult;
    protected ProductDetailsPage productDetailsPage;
    protected RegistrationPage registrationPage;

    protected SoftAssert softAssert;
    protected Properties prop;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browserName){
        driverFactory = new DriverFactory();
        prop = driverFactory.readConfig();
        if(browserName != null) {
            prop.setProperty("browser", browserName);
        }

        this.driver = driverFactory.initDriver(prop);
        driver.get(prop.getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
