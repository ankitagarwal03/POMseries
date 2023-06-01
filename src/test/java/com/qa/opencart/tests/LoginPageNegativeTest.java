package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstent;
import com.qa.opencart.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest extends BaseTest {
    @DataProvider
    public Object[][] loginData(){
        return ExcelUtil.getDataFromSheet(AppConstent.LOGIN_PAGE_SHEET);
    }

    @Test(dataProvider = "loginData")
    public void doInvalidLoginTest(String username, String pwd){
        boolean flag = loginPage.doNegativeLogin(username, pwd);
        Assert.assertEquals(flag, true);

    }

}
