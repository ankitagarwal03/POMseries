package com.qa.opencart.pages;

import com.qa.opencart.utils.AppConstent;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount{

    private WebDriver driver;
    private ElementUtil elementUtil;
    public MyAccount(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By logout = By.linkText("Logout");
    private By myAccount = By.linkText("My Account");
    private By searchBox = By.xpath("//input[@name='search']");
    private By searchIcon = By.cssSelector("button.btn-default");

    public String logout(){
        return elementUtil.doGetElementText(logout);
    }

    public String myAccountText(){
        return elementUtil.doGetElementText(myAccount);
    }

    public String getAccPageTitle(){
        return elementUtil.waitForTitleAndCapture(AppConstent.MY_ACCOUNT_PAGE_TITLE);
    }

    private void doEnterSearchText(String searchText){
        elementUtil.doSendKeys(searchBox, searchText);
    }

    private void doClickOnSearchIcon(){
        elementUtil.doClick(searchIcon);
    }

    public SearchResult doSearchItem(String searchText){
        doEnterSearchText(searchText);
        doClickOnSearchIcon();
        return new SearchResult(driver);
    }


}
