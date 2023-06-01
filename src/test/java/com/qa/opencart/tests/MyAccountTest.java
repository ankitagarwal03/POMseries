package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.dataproviders.ProductDataProvider;
import com.qa.opencart.pojo.ProductPojo;
import com.qa.opencart.utils.AppConstent;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyAccountTest extends BaseTest {

    @BeforeClass
    public void callLoginMethodTest(){
        myAccount = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void getTitleTest(){
        String actTitle = myAccount.getAccPageTitle();
        System.out.println(actTitle);
        Assert.assertEquals(actTitle, AppConstent.MY_ACCOUNT_PAGE_TITLE);
    }

    @Test
    public void logoutTextTest(){
        String actLogoutText = myAccount.logout();
        Assert.assertEquals(actLogoutText,AppConstent.LOGOUT_TEXT);
    }

    @Test
    public void myAccountTest(){
        String actMyAccountText = myAccount.myAccountText();
        Assert.assertEquals(actMyAccountText,AppConstent.MY_ACCOUNT_PAGE_TITLE);
    }

    @DataProvider
    public Object[][] searchKey(){
        return new Object[][]{
                {new ProductPojo("macbook","","")}
        };
    }

    @Test(dataProvider = "searchKey")
    public void searchItemTest(ProductPojo productPojo){
        myAccount.doSearchItem(productPojo.getSearchKey());
    }

}
