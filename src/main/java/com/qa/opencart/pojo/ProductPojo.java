package com.qa.opencart.pojo;

public class ProductPojo {
    private String searchKey;
    private String searchProduct;
    private String searchResultCount;

    public ProductPojo(String searchKey, String searchProduct, String searchResultCount){
        this.searchKey = searchKey;
        this.searchProduct = searchProduct;
        this.searchResultCount = searchResultCount;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSearchProduct() {
        return searchProduct;
    }

    public void setSearchProduct(String searchProduct) {
        this.searchProduct = searchProduct;
    }

    public String getSearchResultCount() {
        return searchResultCount;
    }

    public void setSearchResultCount(String searchResultCount) {
        this.searchResultCount = searchResultCount;
    }


    @Override
    public String toString() {
        return "ProductPojo{" +
                "searchKey='" + searchKey + '\'' +
                ", searchProduct='" + searchProduct + '\'' +
                ", searchResultCount='" + searchResultCount + '\'' +
                '}';
    }
}
