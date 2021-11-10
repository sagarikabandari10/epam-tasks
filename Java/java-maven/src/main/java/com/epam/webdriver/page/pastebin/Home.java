package com.epam.webdriver.page.pastebin;

import com.epam.webdriver.page.pastebin.model.Expiration;
import com.epam.webdriver.page.pastebin.model.Highlighting;
import com.epam.webdriver.util.Implicit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.epam.webdriver.util.WebElementUtils.findElement;
import static com.epam.webdriver.util.WebElementUtils.findElementByElements;

public class Home {
    private static final String HOME_URL = "https://pastebin.com/";

    private static final By name = By.id("postform-name");
    private static final By code = By.id("postform-text");
    private static final By selectHighlighting = By.xpath("//span[@id='select2-postform-format-container']//following::span[@class='select2-selection__arrow']");
    private static final By selectHighlightingItem = By.xpath("//span[@class='select2-results']//child::ul/li[@aria-label='------ POPULAR LANGUAGES -------']/ul/li");
    private static final By selectExpiration = By.xpath("//span[@id='select2-postform-expiration-container']//following::span[@class='select2-selection__arrow']");
    private static final By selectExpirationItem = By.xpath("//span[@class='select2-results']//child::ul/li");
    private static final By submitButton = By.xpath("//button[text()='Create New Paste']");
    private static final By rawPasteData = By.xpath("//textarea[@class='textarea']");

    public static String getRawPasteData(WebDriver driver, String content, String highlight, String expiration, String title) {
        setImplicitWait(driver, 100);

        driver.get(HOME_URL);

        findElement(driver, code).sendKeys(content);

        if(!highlight.equals(Highlighting.None.name()))
            setHighlight(driver, highlight);

        if(!expiration.equals(Expiration.NEVER.getValue()))
            setExpiration(driver, expiration);

        findElement(driver, name).sendKeys(title);
        findElement(driver, submitButton).click();

        return findElement(driver, rawPasteData).getText();
    }

    private static void setExpiration(WebDriver driver, String expiration) {
        findElement(driver, selectExpiration).click();
        findElementByElements(driver, expiration, selectExpirationItem).click();
    }

    private static void setHighlight(WebDriver driver, String highlight) {
        findElement(driver, selectHighlighting).click();
        findElementByElements(driver, highlight, selectHighlightingItem).click();
    }

    private static void setImplicitWait(WebDriver driver, int waitTime) {
        Implicit.setPageTimeOut(driver,waitTime,TimeUnit.SECONDS);
        Implicit.setTimeOut(driver,waitTime,TimeUnit.SECONDS);
    }
}
