package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    private By email = By.id("input-email");
    private By pwd = By.id("input-password");
    private By submit = By.xpath("//input[@type='submit']");
    private By forgotPassword = By.linkText("Forgotten Password");

    private By loginErrorMsg = By.cssSelector("div.alert.alert-danger");

    private By register = By.linkText("Register");

    public String enterUserName(String userName){
        elementUtil.doSendKeys(email,userName);
        return elementUtil.doGetElementAttributeText(email, "value");
    }

    public MyAccount doLogin(String userName, String passwd){
        elementUtil.doSendKeys(email, userName);
        elementUtil.doSendKeys(pwd, passwd);
        elementUtil.doClick(submit);
        return new MyAccount(driver);
    }

    public String enterPwd(String passwd){
        elementUtil.doSendKeys(pwd, passwd);
        return elementUtil.doGetElementAttributeText(pwd, "value");
    }

    public String submit(){
        String buttonText = elementUtil.doGetElementAttributeText(submit, "value");
        elementUtil.doClick(submit);
        return buttonText;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getForgotPasswordLinkText(){
        return elementUtil.doGetElementText(forgotPassword);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public boolean doNegativeLogin(String userName, String passwd){
        elementUtil.doSendKeys(email, userName);
        elementUtil.doSendKeys(pwd, passwd);
        elementUtil.doClick(submit);
        String errorMsg = elementUtil.doGetElementText(loginErrorMsg);
        if(errorMsg.contains("Warning: No match for E-Mail Address and/or Password")){
            return true;
        }
        return false;
    }

    public RegistrationPage doClickOnRegisterLink(){
         elementUtil.doClick(register);
         return new RegistrationPage(driver);
    }

}
