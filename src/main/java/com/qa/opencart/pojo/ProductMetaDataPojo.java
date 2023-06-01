package com.qa.opencart.pojo;

public class ProductMetaDataPojo {
    private String brand;
    private String product_code;
    private String reward_point;

    public ProductMetaDataPojo(String brand, String product_code, String reward_point, String availability) {
        this.brand = brand;
        this.product_code = product_code;
        this.reward_point = reward_point;
        this.availability = availability;
    }

    private String availability;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getReward_point() {
        return reward_point;
    }

    public void setReward_point(String reward_point) {
        this.reward_point = reward_point;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ProductMetaDataPojo{" +
                "brand='" + brand + '\'' +
                ", product_code='" + product_code + '\'' +
                ", reward_point='" + reward_point + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
