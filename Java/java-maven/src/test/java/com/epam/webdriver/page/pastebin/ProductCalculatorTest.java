package com.epam.webdriver.page.pastebin;

import com.epam.webdriver.page.cloud.google.ProductCalculator;
import com.epam.webdriver.page.driver.Browser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductCalculatorTest {
    private ProductCalculator calculator;

    @BeforeEach
    void setUp() {
        WebDriver driver = Browser.setup();
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

    @AfterEach
    void tearDown() {
        Browser.tearDown();
    }
}
