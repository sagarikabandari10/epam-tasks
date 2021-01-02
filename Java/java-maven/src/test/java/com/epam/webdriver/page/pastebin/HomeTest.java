package com.epam.webdriver.page.pastebin;

import com.epam.webdriver.page.driver.Browser;
import com.epam.webdriver.page.pastebin.model.Expiration;
import com.epam.webdriver.page.pastebin.model.Highlighting;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

class HomeTest {
    private static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = Browser.setup();
    }

    @AfterEach
    void tearDown() {
        Browser.tearDown();
    }

    @Test
    void getData() {
        String expected = "Hello from WebDriver";
        String actual = Home.getRawPasteData(driver, expected, Highlighting.None.name(), Expiration.NEVER.getValue(),"hello");
        Assert.assertEquals(actual, expected);
    }
}