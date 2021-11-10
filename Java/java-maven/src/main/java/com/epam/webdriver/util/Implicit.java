package com.epam.webdriver.util;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Implicit {
    public static void setTimeOut(WebDriver driver,long time, TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    public static void setPageTimeOut(WebDriver driver,long time, TimeUnit timeUnit){
        driver.manage().timeouts().pageLoadTimeout(time, timeUnit);
    }
}
