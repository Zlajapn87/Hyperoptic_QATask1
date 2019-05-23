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
        driver = new ChromeDriver();
        uqForms = PageFactory.initElements(driver, FillingOutForms.class); //page factory

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFormNegative(){
        uqForms.loadPage();
        uqForms.setTtext_Name("test");
        uqForms.setTtext_Message("test");
        uqForms.setTtext_Captcha("-1");

        //Getting the initial Captcha Value, which will be validated
        String initialValue = uqForms.getText_Captcha();
        uqForms.click_Submit();

        //Validation that captcha value has been altered upon the submit action
        Assert.assertNotEquals(initialValue, uqForms.getText_Captcha());
    };

}
