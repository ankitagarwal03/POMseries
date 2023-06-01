package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDetailsPage{
    protected WebDriver driver;
    protected ElementUtil elementUtil;
    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    protected By productName = By.cssSelector("div.col-sm-4 h1");

    protected By productMetaData = By.xpath("(//div[@id='content']//div[@class='col-sm-4']/ul)[1]/li");

    protected By productPrice = By.xpath("(//div[@id='content']//div[@class='col-sm-4']/ul)[2]/li");

    public String doGetProductName(){
        return elementUtil.doGetElementText(productName);
    }

    public Map<String,String> doGetProductMetaDetails(){
        Map<String,String> metaMap = new HashMap<>();
        List<WebElement> metaList = elementUtil.getElements(productMetaData);
        for(int i=0;i<metaList.size();i++){
            String[] metaArray = metaList.get(i).getText().split(":");
            metaMap.put(metaArray[0].trim(), metaArray[1].trim());
        }
        return metaMap;
    }

    public List<WebElement> doGetProductPrice(){
        return elementUtil.getElements(productPrice);
    }






}
