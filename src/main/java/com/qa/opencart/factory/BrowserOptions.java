package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class BrowserOptions {
    private Properties prop;
    private FirefoxOptions fo;
    private EdgeOptions eo;

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
    public FirefoxOptions getFirefoxOptions() {
        fo = new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless"))) {
            fo.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
            fo.addArguments("--incognito");
        }
        return fo;
    }

    public EdgeOptions getEdgeOptions() {
        eo = new EdgeOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless"))) {
            eo.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
            eo.addArguments("--incognito");
        }
        return eo;
    }
}
