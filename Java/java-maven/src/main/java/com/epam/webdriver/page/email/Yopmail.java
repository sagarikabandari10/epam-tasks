package com.epam.webdriver.page.email;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epam.webdriver.page.driver.Utils.findElement;
import static com.epam.webdriver.page.driver.Utils.selectWebElement;

public class Yopmail {
    private final WebDriver driver;
    private static final String YOP_MAIL_URL = "https://yopmail.com/";

    private static final String frameName = "ifmail";
    private static final By randomEmailAddressButton = By.xpath("//div[@id='listeliens']//a");
    private static final By copyEmail = By.xpath("//div[@id='egen']");
    private static final By checkInboxButton = By.xpath("//span[contains(text(),'Check Inbox')]//parent::button");
    private static final By costEstimation = By.xpath("//div[@id='mail']//table//table//tr/td[2]//h3");

    public Yopmail(WebDriver driver){
        this.driver = driver;
        this.driver.get(YOP_MAIL_URL);
    }

    public String GetRandomEmail(){
        selectWebElement(driver, randomEmailAddressButton);
        return findElement(driver, copyEmail).getText();
    }

    public String GetEstimationCost(){
        selectWebElement(driver, checkInboxButton);
        driver.switchTo().frame(frameName);
        return findElement(driver, costEstimation).getText();
    }

}
