package com.epam.webdriver.page.pastebin;

import com.epam.webdriver.driver.Browser;
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
        System.setProperty("browser", "chrome");
        driver = Browser.getDriver();
    }

    @AfterEach
    void tearDown() {
        Browser.tearDown();
    }

    @Test
    void ICanWin() {
        String expected = "Hello from WebDriver";
        String title = "helloweb";
        String actual = Home.getRawPasteData(driver, expected, Highlighting.None.name(), Expiration.TEN_MINUTES.getValue(),title);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void BringItOn() {
        String expected = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String title = "how to gain dominance among developers";
        String actual = Home.getRawPasteData(driver, expected, Highlighting.Bash.name(), Expiration.TEN_MINUTES.getValue(),title);
        Assert.assertEquals(actual, expected);
    }
}