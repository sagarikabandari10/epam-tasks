package com.epam.webdriver.page.pastebin;

import com.epam.webdriver.driver.Browser;
import com.epam.webdriver.page.pastebin.model.Expiration;
import com.epam.webdriver.page.pastebin.model.Highlighting;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class HomeTest {
    private static WebDriver driver;

    @BeforeClass
    void setUp() {
        System.setProperty("browser", "chrome");
        driver = Browser.getDriver();
    }

    @AfterClass
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