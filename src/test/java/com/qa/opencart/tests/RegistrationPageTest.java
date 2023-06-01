package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationPageTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        registrationPage = loginPage.doClickOnRegisterLink();
    }

    private String emailGenerator(){
        return "automationTest"+System.currentTimeMillis()+"@gmail.com";
    }

    @DataProvider
    public Object[][] regData(){
        return new Object[][]{
                {"Ankit", "agarwal", "998899999", "123456","yes"},
                {"Ankit1", "agarwal1", "998899999", "123456","no"}
        };
    }

    @Test(dataProvider = "regData")
    public void doRegistrationPageTest(String fname, String lname,
                                       String phone, String pwd, String subscribe){
        registrationPage.doRegistration(fname, lname , emailGenerator(), phone, pwd, subscribe);
    }


}
