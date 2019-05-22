package com.ultimateqa.forms.tests;

import com.ultimateqa.Pages.FillingOutForms;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Invalid_Input_Test {

    public WebDriver driver;
    FillingOutForms uqForms;



    @BeforeClass(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/Drivers/chromedriver_74.exe");
        driver = new ChromeDriver(); //Driver has to be created before the page.
        uqForms = PageFactory.initElements(driver, FillingOutForms.class); //page factory

    }
/*
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
*/
    @Test //Data Provider Classa
    public void testFormNegative(){
        uqForms.loadPage();
        uqForms.setTtext_Name("test");
        uqForms.setTtext_Message("test");
        uqForms.setTtext_Captcha("-1");

        //Getting the initial Captcha Value, which will be validated later & click on Submit button
        String initialValue = uqForms.getText_Captcha(); System.out.println("Initial Value is:" + initialValue);
        uqForms.click_Submit();

        //Validation that initial captcha value and captcha value upon the Submit action are not the same
        //Note: Captcha value should be altered
        Assert.assertNotEquals(initialValue, uqForms.getText_Captcha());
    };




}
