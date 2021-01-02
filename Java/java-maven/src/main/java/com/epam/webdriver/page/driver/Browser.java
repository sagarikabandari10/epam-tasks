package com.epam.webdriver.page.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Browser {

    private static WebDriver driver;

    public static WebDriver setup(){
        if(driver == null){
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Sagarika\\Webdriver\\chromedriver_win32\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--diable--notifications");
            options.addArguments("--no-sandbox");//#bypass OS security model
//            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static void tearDown(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
