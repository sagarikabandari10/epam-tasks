package com.epam.webdriver.page.driver;

import com.epam.webdriver.page.wait.Explicit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {

    public static WebElement findElementByElements(WebDriver driver, String value, By elements) {
        List<WebElement> list = driver.findElements(elements);
        for (WebElement l : list) {
            if (l.getText().equals(value)) {
                return l;
            }
        }
        return null;
    }

    public static WebElement findElement(WebDriver driver, By by) {
        return Explicit.waitBy(driver,by, 10);
    }

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
