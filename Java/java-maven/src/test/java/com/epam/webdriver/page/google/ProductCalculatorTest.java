package com.epam.webdriver.page.google;

import com.epam.webdriver.driver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductCalculatorTest {
    private ProductCalculator calculator;

    @BeforeClass
    void setUp() {
        System.setProperty("browser", "edge");
        WebDriver driver = Browser.getDriver();
        calculator = new ProductCalculator(driver);
    }

    @Test
    void hurtMePlenty() {
        String expectedCost = "USD 1,842.53";
        String actualCost = calculator.getEstimateComputeEngine();
        Assert.assertTrue(actualCost.contains(expectedCost));
    }

    @Test
    void hardCore() {
        String totalCost = calculator.getEstimateComputeEngine();
        String emailTotalCost = calculator.sendEmail();
        Assert.assertTrue(totalCost.contains(emailTotalCost));
    }

    @AfterClass
    void tearDown() {
        Browser.tearDown();
    }
}
