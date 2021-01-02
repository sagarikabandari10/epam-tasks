package com.epam.webdriver.page.wait;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Implicit {
    public static void setTimeOut(WebDriver driver,long time, TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }
}
