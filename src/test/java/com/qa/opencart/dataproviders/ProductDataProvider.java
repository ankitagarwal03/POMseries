package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

public class ProductDataProvider {
    @DataProvider
    public Object[][] searchKey(){
        return new Object[][]{
                {"macbook"},
                {"imac"}
        };
    }

    @DataProvider
    public Object[][] searchProduct(){
        return new Object[][]{
                {"macbook","MacBook Pro"},
                {"imac","iMac"}
        };
    }

    @DataProvider
    public Object[][] searchResult(){
        return new Object[][]{
                {"macbook","3"},
                {"imac","1"}
        };
    }

}
