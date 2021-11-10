package com.epam.webdriver.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.epam.webdriver.util.WebElementUtils.findElement;

public class JavascriptExecutorUtils {

    public static void selectWebElement(WebDriver driver, By by) {
        WebElement ele = findElement(driver, by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ele);
    }

    public static void openNewTab(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open();");
    }
}
