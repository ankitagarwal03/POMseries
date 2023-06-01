package com.qa.opencart.utils;

import com.qa.opencart.frameWorKException.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;
    private final int DEFAULT_TIME_OUT = 10;

    public ElementUtil(WebDriver driver){
        this.driver = driver;
    }

    public void doClick(By locator){
        getElement(locator).click();
    }

    public void doWaitAndClick(By locator){
        waitForElementClickable(locator).click();
    }

    public void doSendKeys(By locator, String value){
        if(value == null){
            new FrameworkException("VALUEISNULL");
        }
        WebElement ele = driver.findElement(locator);
        ele.clear();
        ele.sendKeys(value);
    }


    public WebElement waitForElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForElementsVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String waitForTitleAndCapture(String title){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    public WebElement getElement(By locator){
        WebElement ele = null;
        try {
            ele = driver.findElement(locator);
        }
        catch (NoSuchElementException e){
            System.out.println("element not found "+e);
            ele = waitForElementVisible(locator);
        }
        return ele;
    }


    public List<WebElement> getElements(By locator){
        List<WebElement> li;
        try {
            li = driver.findElements(locator);
        }
        catch (NoSuchElementException e){
            System.out.println("element not found "+e);
            li = waitForElementsVisibility(locator);
        }
        return li;
    }

    public void doClear(By locator){
        getElement(locator).clear();
    }

    public String doGetElementText(By locator){
        return getElement(locator).getText();
    }

    public String doGetElementAttributeText(By locator, String attribute){
        return getElement(locator).getAttribute(attribute);
    }

    public boolean checkElementIsDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }

    public List<String> doGetElementsTextList(By locator){
        List<WebElement> li = getElements(locator);
        List<String> textList = new ArrayList<>();
        for(WebElement e: li){
            textList.add(e.getText());
        }
        return textList;
    }

    public List<String> doGetElementsAttributeValue(By locator, String attriValue){
        List<WebElement> li = getElements(locator);
        List<String> attriList = new ArrayList<>();
        for(WebElement e: li){
            attriList.add(e.getAttribute(attriValue));
        }
        return attriList;
    }



}
