package com.qa.opencart.factory;

import com.qa.opencart.frameWorKException.FrameworkException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    WebDriver driver;
    OptionsManager browserOptions;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public synchronized static WebDriver getDriver() {
        return tlDriver.get();
    }
    public WebDriver initDriver(Properties prop) {
        String browserName = prop.getProperty("browser").trim();

        // String browserName = System.getProperty("browser");

        System.out.println("browser name is : " + browserName);

//        highlightElement = prop.getProperty("highlight");

        browserOptions = new OptionsManager(prop);

        switch (browserName.toLowerCase()) {
            case "chrome":
                // driver = new ChromeDriver(optionsManager.getChromeOptions());
                tlDriver.set(new ChromeDriver(browserOptions.getChromeOptions()));
                break;
            case "edge":
                // driver = new EdgeDriver(optionsManager.getEdgeOptions());
                tlDriver.set(new EdgeDriver(browserOptions.getEdgeOptions()));
                break;
            case "safari":
                // driver = new SafariDriver();
                tlDriver.set(new SafariDriver());
                break;
            case "firefox":
                // driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
                tlDriver.set(new FirefoxDriver(browserOptions.getFirefoxOptions()));
                break;

            default:
                System.out.println("plz pass the right browser ...." + browserName);
                throw new FrameworkException("NOBROWSERFOUNDEXCEPTION");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
        return getDriver();

    }


    public Properties readConfig(){
        Properties prop = new Properties();
        FileInputStream ip = null;

        String envName = System.getProperty("env");

        System.out.println(envName);
        try {
            if(envName == null) {
                System.out.println("inside the null so picking default");
                ip = new FileInputStream("./src/main/config/config.properties");

            }
            else{
                switch (envName.toLowerCase().trim()){
                    case "qa":
                        System.out.println("inside the qa");
                        ip = new FileInputStream("./src/main/config/qa_config.properties");
                        break;
                    case "dev":
                        System.out.println("inside the dev");
                        ip = new FileInputStream("./src/main/config/dev_config.properties");
                        break;
                    case "prod":
                        System.out.println("inside the prod");
                        ip = new FileInputStream("./src/main/config/prod_config.properties");
                        break;
                    default:
                        System.out.println("not found any file");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    /**
     * take screenshot
     */
    public static String getScreenshot() {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }


}
