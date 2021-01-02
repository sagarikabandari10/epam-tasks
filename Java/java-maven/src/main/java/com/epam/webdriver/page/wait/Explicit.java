package com.epam.webdriver.page.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Explicit {
    public static WebElement waitBy(WebDriver driver, By by, int timeout) {
        return new WebDriverWait(driver, timeout)
        .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForElementToClickable(WebDriver driver, WebElement element,int timeout) {
        return waitForCondition(driver, ExpectedConditions.elementToBeClickable(element), timeout);
    }

    public static WebElement waitForCondition(WebDriver driver, ExpectedCondition condition, int timeout) {
        return (WebElement) new WebDriverWait(driver, timeout)
                .until(condition);
    }

}
