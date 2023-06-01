package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import com.qa.opencart.pojo.ProductPojo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchResultTestWithPojo extends BaseTest {
    @BeforeClass
    public void setUp(){
        myAccount = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @DataProvider
    public Object[][] searchProduct(){
        return new Object[][]{
                {new ProductPojo("macbook","MacBook Pro","3")},
                {new ProductPojo("imac","iMac","1")}
        };
    }

    @Test(priority = 0, dataProvider = "searchProduct")
    public void doVerifyTitleTest(ProductPojo productPojo){
        searchResult = myAccount.doSearchItem(productPojo.getSearchKey());
        String actTitle = searchResult.doGetTitle();
        System.out.println(actTitle);
        Assert.assertTrue(actTitle.contains(productPojo.getSearchKey()));
    }

    @Test(priority = 1,  dataProvider = "searchProduct")
    public void doGetHeaderTextTest(ProductPojo productPojo){
        searchResult = myAccount.doSearchItem(productPojo.getSearchKey());
        String actHeader = searchResult.doGetHeaderText();
        System.out.println(actHeader);
        Assert.assertTrue(actHeader.contains(productPojo.getSearchKey()));
    }

    @Test(priority = 2, dataProvider = "searchProduct")
    public void doGetTotalSearchResultTest(ProductPojo productPojo){

        searchResult = myAccount.doSearchItem(productPojo.getSearchKey());
        int actProductCount = searchResult.getSearchResultCount();
        Assert.assertEquals(actProductCount, Integer.parseInt(productPojo.getSearchResultCount()));
    }

    @Test(priority = 3, dataProvider = "searchProduct")
    public void doSelectProduct(ProductPojo productPojo){

        searchResult = myAccount.doSearchItem(productPojo.getSearchKey());
        String actTitle = searchResult.doGetTitle();
        productDetailsPage = searchResult.selectProduct(productPojo.getSearchProduct());
        String actProductName = productDetailsPage.doGetProductName();
        Assert.assertEquals(actProductName, productPojo.getSearchProduct());
    }


}
