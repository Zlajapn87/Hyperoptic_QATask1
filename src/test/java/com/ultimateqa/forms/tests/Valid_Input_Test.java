package com.ultimateqa.forms.tests;

import com.ultimateqa.Pages.FillingOutForms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Valid_Input_Test {

    public WebDriver driver;
    FillingOutForms uqForms;

    @BeforeClass(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/Drivers/chromedriver_74.exe");
        driver = new ChromeDriver(); //Driver has to be created before the page.
        uqForms = PageFactory.initElements(driver, FillingOutForms.class); //page factory

    };


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFormPositive(){
        uqForms.loadPage();
        uqForms.setTtext_Name("test");
        uqForms.setTtext_Message("test");


        //Getting the Captcha Value(s)
        int firstDigit = uqForms.getFirstDigint();
        int secondDigit = uqForms.getSecondDigint();
        int result = firstDigit + secondDigit;
        uqForms.setTtext_Captcha(Integer.toString(result));
        uqForms.click_Submit();
        WebDriverWait wait = new WebDriverWait(driver, 2);

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id = 'et_pb_contact_form_1']/div/p")))).getText(), "Success");


    };
}

