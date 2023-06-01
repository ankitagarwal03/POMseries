package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class BrowserOptions {
    private Properties prop;

    public BrowserOptions(Properties prop) {
        System.out.println("inside the browser option const");
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (Boolean.parseBoolean(prop.getProperty("headless"))) {
            chromeOptions.addArguments("--headless");
        }
        System.out.println("prop.getProperty(\"incognito\")" + prop.getProperty("incognito"));
        if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
            System.out.println("inside the incognito code");
            chromeOptions.addArguments("--incognito");
        }
        return chromeOptions;
    }
}
