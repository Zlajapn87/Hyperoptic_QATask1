package com.ultimateqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseClass {

    public String PAGE_URL;
    public String PAGE_TITLE;
    public WebDriver driver;
    public WebDriverWait wait;

    //Contructor
    public BaseClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5); //explicit wait
    };

    public void loadPage(){
        driver.get(getPageUrl());
        Assert.assertTrue((driver.getTitle()).contains(getPageTitle()));
    };
    public void setElementText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    };
    public void clickElement(WebElement element){
        element.click();
    };

    public String getDigit(WebElement element, String attribute){
       return element.getAttribute(attribute);
    }

    public String getPageUrl(){
        return PAGE_URL;
    };
    public String getPageTitle(){
        return PAGE_TITLE;
    };























}
