package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchResultTest extends BaseTest {
    @BeforeClass
    public void setUp(){
        myAccount = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 0, dataProviderClass = ProductDataProvider.class, dataProvider = "searchKey")
    public void doVerifyTitleTest(String searchKey){
        searchResult = myAccount.doSearchItem(searchKey);
        String actTitle = searchResult.doGetTitle();
        System.out.println(actTitle);
        Assert.assertTrue(actTitle.contains(searchKey));
    }

    @Test(priority = 1, dataProviderClass = ProductDataProvider.class, dataProvider = "searchKey")
    public void doGetHeaderTextTest(String searchKey){
        searchResult = myAccount.doSearchItem(searchKey);
        String actHeader = searchResult.doGetHeaderText();
        System.out.println(actHeader);
        Assert.assertTrue(actHeader.contains(searchKey));
    }

    @Test(priority = 2, dataProviderClass = ProductDataProvider.class, dataProvider = "searchResult")
    public void doGetTotalSearchResultTest(String searchKey,String searchResultCount){

        searchResult = myAccount.doSearchItem(searchKey);
        int actProductCount = searchResult.getSearchResultCount();
        Assert.assertEquals(actProductCount, Integer.parseInt(searchResultCount));
    }

    @Test(priority = 3, dataProviderClass = ProductDataProvider.class, dataProvider = "searchProduct")
    public void doSelectProduct(String searchKey,String searchProduct){

        searchResult = myAccount.doSearchItem(searchKey);
        String actTitle = searchResult.doGetTitle();
        productDetailsPage = searchResult.selectProduct(searchProduct);
        String actProductName = productDetailsPage.doGetProductName();
        Assert.assertEquals(actProductName, searchProduct);
    }


}
