package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pojo.ProductMetaDataPojo;
import com.qa.opencart.pojo.ProductPojo;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class ProductDetailsPageTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        myAccount = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        softAssert = new SoftAssert();
    }

    @DataProvider
    public Object[][] searchDataFun(){
        Object[][] obj = {
                {new ProductPojo("Macbook","MacBook Pro","")}
        };
        return obj;
    }

    @Test(dataProvider = "searchDataFun", priority = 0)
    public void searchProductNameTest(ProductPojo productPojo){
        searchResult = myAccount.doSearchItem(productPojo.getSearchKey());
        productDetailsPage = searchResult.selectProduct(productPojo.getSearchProduct());
        String actProductName = productDetailsPage.doGetProductName();
        Assert.assertEquals(actProductName, productPojo.getSearchProduct());
    }
    @DataProvider
    public Object[][] productMetaData(){
        return new Object[][]{
                {new ProductMetaDataPojo("Apple","Product 18","800","In Stock")}
        };
    }

    @Test(priority = 1, dataProvider = "productMetaData")
    public void productMetaDetailTest(ProductMetaDataPojo productMetaDataPojo){
        Map<String, String> productMap = productDetailsPage.doGetProductMetaDetails();
        softAssert.assertEquals(productMap.get("Brand"), productMetaDataPojo.getBrand());
        softAssert.assertEquals(productMap.get("Product Code"), productMetaDataPojo.getProduct_code());
        softAssert.assertEquals(productMap.get("Reward Points"), productMetaDataPojo.getReward_point());
        softAssert.assertEquals(productMap.get("Availability"), productMetaDataPojo.getAvailability());
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] productPriceData(){
        return new Object[][]{
                {"$2,000.00","$2,000.00"}
        };
    }

    @Test(priority = 2, dataProvider = "productPriceData")
    public void productPriceTest(String amount, String amountWithTax){
        List<WebElement> priceList = productDetailsPage.doGetProductPrice();
        String actPrice = priceList.get(0).getText();
        softAssert.assertEquals(actPrice, amount);
        String[] priceWithTax = priceList.get(1).getText().split(":");
        softAssert.assertEquals(priceWithTax[1].trim(), amountWithTax);
        softAssert.assertAll();
    }

}
