package com.epam.webdriver.page.cloud.google;

import com.epam.webdriver.page.email.Yopmail;
import com.epam.webdriver.page.wait.Implicit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.epam.webdriver.page.driver.Utils.*;

public class ProductCalculator {
    private static WebDriver driver;

    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";//"https://cloud.google.com/products/calculator";

    private static final String frameName = "myFrame";
    private static final String searchText = "Google Cloud Platform Pricing Calculator";

    private static final By searchButton = By.xpath("//form[@class='devsite-search-form']//div[@class='devsite-searchbox']");
    private static final By searchInput = By.xpath("//form[@class='devsite-search-form']//input[@name='q']");
    private static final By searchResultLink = By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']//parent::a[@data-ctorig='https://cloud.google.com/products/calculator']");


    private static final By computeEngineTab = By.xpath("//md-tab-item//div[@title='Compute Engine']");
    private static final By numOfInstances = By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']");

    private static final By operatingSystemSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.os']");
    private static final By operatingSystemOption = By.xpath("//md-option[@id='select_option_70']");

    private static final By machineClassSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.class']");
    private static final By machineClassOption = By.xpath("//md-option[@id='select_option_83']");

    private static final By seriesSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.series']");
    private static final By seriesOption = By.xpath("//div[contains(text(),'N1')]//parent::md-option[@value='n1']");

    private static final By machineTypeSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.instance']");
    private static final By machineTypeOption = By.xpath("//md-option[@id='select_option_398']");

    private static final By addGPUsCheckbox = By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']");

    private static final By numOfGPUsSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']");
    private static final By numOfGPUsOption = By.xpath("//md-option[@id='select_option_437']");

    private static final By typeOfGPUSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']");
    private static final By typeOfGPUOption = By.xpath("//div[contains(text(),'NVIDIA Tesla T4')]//parent::md-option[@value='NVIDIA_TESLA_T4']");

    private static final By localSSDSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.ssd']");
    private static final By localSSDOption = By.xpath("//div[contains(text(),'2x375 GB')]//parent::md-option[@value='2']");

    private static final By dataCenterSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.location']");
    private static final By dataCenterOption = By.xpath("//md-option[@id='select_option_219']");

    private static final By committedUsageSelect = By.xpath("//md-select[@ng-model='listingCtrl.computeServer.cud']");
    private static final By committedUsageOption = By.xpath("//md-option[@id='select_option_102']");

    private static final By addToEstimateButton = By.xpath("//button[@aria-label='Add to Estimate']");
    private static final By emailEstimateButton = By.xpath("//button[@aria-label='Email Estimate']");
    private static final By totalCostEstimation = By.xpath("//h2[@class='md-title']//b[@class='ng-binding']");

    private static final By emailAddress = By.xpath("//form[@name='emailForm']//child::input[@ng-model='emailQuote.user.email']");
    private static final By sendEmailButton = By.xpath("//form[@name='emailForm']//child::button[@aria-label='Send Email']");

    public ProductCalculator(WebDriver driver) {
        ProductCalculator.driver = driver;
        ProductCalculator.driver.get(GOOGLE_CLOUD_URL);
        Implicit.setPageTimeOut(driver,150,TimeUnit.SECONDS);
        Implicit.setTimeOut(driver,150,TimeUnit.SECONDS);

    }

    public String getEstimateComputeEngine(){
        selectWebElement(driver, searchButton);
        findElement(driver, searchInput).sendKeys(searchText);
        findElement(driver, searchInput).sendKeys(Keys.ENTER);
        selectWebElement(driver, searchResultLink);

        driver.switchTo().frame(0).switchTo().frame(frameName);
        selectWebElement(driver, computeEngineTab);

        findElement(driver, numOfInstances).sendKeys("4");
        findElement(driver,operatingSystemSelect).click();
        selectWebElement(driver, operatingSystemOption);

        findElement(driver, machineClassSelect).click();
        findElement(driver, machineClassOption).click();

        findElement(driver, seriesSelect).click();
        selectWebElement(driver, seriesOption);

        findElement(driver, machineTypeSelect).click();
        selectWebElement(driver, machineTypeOption);

        selectWebElement(driver, addGPUsCheckbox);

        findElement(driver, numOfGPUsSelect).click();
        selectWebElement(driver, numOfGPUsOption);

        findElement(driver, typeOfGPUSelect).click();
        selectWebElement(driver, typeOfGPUOption);

        findElement(driver, localSSDSelect).click();
        selectWebElement(driver, localSSDOption);

        findElement(driver, dataCenterSelect).click();
        selectWebElement(driver, dataCenterOption);

        findElement(driver, committedUsageSelect).click();
        selectWebElement(driver, committedUsageOption);
        findElement(driver, addToEstimateButton).click();

        String totalCost = findElement(driver, totalCostEstimation).getText();
        System.out.println(totalCost);
        return totalCost;
    }

    public String sendEmail(){
        openNewTab(driver);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Yopmail mail = new Yopmail(driver);
        String email=mail.GetRandomEmail();
        System.out.println(email);

        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0).switchTo().frame(frameName);
        findElement(driver, emailEstimateButton).click();
        findElement(driver, emailAddress).sendKeys(email);
        selectWebElement(driver, sendEmailButton);

        driver.switchTo().window(tabs.get(1));
        String actualCost = mail.GetEstimationCost();
        System.out.println(actualCost);
        return actualCost;
    }
}
