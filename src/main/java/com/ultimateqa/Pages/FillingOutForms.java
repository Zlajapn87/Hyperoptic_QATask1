package com.ultimateqa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class FillingOutForms extends BaseClass{

    //Locators related to the relevant elements, present on ultimateeqa ->filling - out - forms page
    @FindBy(xpath = "//input[@id = \"et_pb_contact_name_1\"]") WebElement field_Name;
    @FindBy(xpath = "//textarea[@id= \"et_pb_contact_message_1\"]") WebElement field_Message;
    @FindBy(xpath = "//input[@class=\"input et_pb_contact_captcha\"]") WebElement field_Sum;
    @FindBy(xpath = "//span[@class=\"et_pb_contact_captcha_question\"]") WebElement field_Captcha;
    @FindBy(xpath = "(//button[@type= \"submit\"])[2]") WebElement button_Submit;

    String attributeFirstDigit = "data-first_digit";
    String attributeSecondDigit = "data-second_digit";


    public FillingOutForms(WebDriver driver) {
        super(driver);
        this.PAGE_TITLE = "Filling Out Forms - Ultimate QA";
        this.PAGE_URL = "https://www.ultimateqa.com/filling-out-forms/";
    }

    //Methods required for the testing purpose (filling - out - forms page)
    public void setTtext_Name(String text) {
        setElementText(field_Name, text);
    };
    public void setTtext_Message(String text) {
        setElementText(field_Message, text);
    };
    public void setTtext_Captcha(String text) {
        setElementText(field_Sum, text);
    };

    public void click_Submit(){
        clickElement(button_Submit);
    };
    public int getFirstDigint(){
       return Integer.parseInt(getDigit(field_Sum, attributeFirstDigit));
    };
    public int getSecondDigint(){
        return Integer.parseInt(getDigit(field_Sum, attributeSecondDigit));
    };
    public String getText_Captcha(){
        return field_Captcha.getText();
    };




}
