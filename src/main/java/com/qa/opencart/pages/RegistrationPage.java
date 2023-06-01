package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import jdk.jfr.DataAmount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

public class RegistrationPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    private By firstName        = By.id("input-firstname");
    private By lastName         = By.id("input-lastname");
    private By email            = By.id("input-email");
    private By phone            = By.id("input-telephone");
    private By password         = By.id("input-password");
    private By confrmPassword   = By.id("input-confirm");
    private By subscribeYes     = By.xpath("(//div[@class='form-group']/div/label)[1]/input");
    private By subscribeNo      = By.xpath("(//div[@class='form-group']/div/label)[2]/input");
    private By privacyPolicy    = By.name("agree");
    private By continueButton   = By.xpath("//input[@type='submit']");
    private By logout           = By.linkText("Logout");
    private By register         = By.linkText("Register");


    /**
     *  use this method to register a new user
     */
    public void doRegistration(String fName, String lName, String email, String phone,
                               String pwd, String subscribe){
        elementUtil.doSendKeys(firstName, fName);
        elementUtil.doSendKeys(lastName, lName);
        elementUtil.doSendKeys(this.email, email);
        elementUtil.doSendKeys(this.phone, phone);
        elementUtil.doSendKeys(password, pwd);
        elementUtil.doSendKeys(confrmPassword, pwd);
        if(subscribe.equalsIgnoreCase("yes")){
            elementUtil.doClick(subscribeYes);
        }
        else {
            elementUtil.doClick(subscribeNo);
        }
        elementUtil.doClick(privacyPolicy);
        elementUtil.doClick(continueButton);

        elementUtil.doWaitAndClick(logout);
        elementUtil.doWaitAndClick(register);

    }


}
