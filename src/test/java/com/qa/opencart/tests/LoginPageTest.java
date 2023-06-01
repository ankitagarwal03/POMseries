package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 0)
    public void getTitleTest(){
        String actTitle = loginPage.getTitle();
        Assert.assertEquals(actTitle, AppConstent.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 1)
    public void getForgotPasswordTextTest(){
        String actTitle = loginPage.getForgotPasswordLinkText();
        Assert.assertEquals(actTitle,AppConstent.FORGOTTON_PASSWORD_TEXT);
    }

    @Test(priority = 2)
    public void getTitleUrl(){
        String actUrl = loginPage.getUrl();
        Assert.assertTrue(actUrl.contains("route=account/login"));
    }

//    @DataProvider
//    public Object[][] loginData(){
//        Object[][] obj = {
//                {"an@ss.com","1234"},
//                {"an1@ss.com",""},
//                {"","123"},
//        };
//
//        return obj;
//    }

    @Test(priority = 3)
    public void doLoginTest(){
        myAccount = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        System.out.println(myAccount.getAccPageTitle());
        Assert.assertTrue(myAccount.getAccPageTitle().equals("My Account"));
    }

}
