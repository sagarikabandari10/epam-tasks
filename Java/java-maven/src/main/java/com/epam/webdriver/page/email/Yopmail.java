package com.epam.webdriver.page.email;

import com.epam.webdriver.util.JavascriptExecutorUtils;
import com.epam.webdriver.util.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        JavascriptExecutorUtils.selectWebElement(driver, randomEmailAddressButton);
        return WebElementUtils.findElement(driver, copyEmail).getText();
    }

    public String GetEstimationCost(){
        JavascriptExecutorUtils.selectWebElement(driver, checkInboxButton);
        driver.switchTo().frame(frameName);
        return WebElementUtils.findElement(driver, costEstimation).getText();
    }

}
