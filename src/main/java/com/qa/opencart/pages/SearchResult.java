package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResult {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public SearchResult(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }
    private By searchHeader = By.cssSelector("div#content h1");
    private By searchProductCount = By.cssSelector("div.product-layout.product-grid");

    public int getSearchResultCount(){
        List<WebElement> li = elementUtil.getElements(searchProductCount);
        return li.size();
    }

    public String doGetHeaderText(){
        return elementUtil.doGetElementText(searchHeader);
    }

    public String doGetTitle(){
        return driver.getTitle();
    }

    public ProductDetailsPage selectProduct(String productName){
        By productLocator = By.linkText(productName);
        elementUtil.doWaitAndClick(productLocator);
        return new ProductDetailsPage(driver);
    }



}
