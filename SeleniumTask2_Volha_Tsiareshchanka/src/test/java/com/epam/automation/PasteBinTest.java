package com.epam.automation;


import com.epam.automation.pages.PasteBin;
import com.epam.automation.pages.PasteBinResults;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasteBinTest {

    private WebDriver driver;

    private final String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    private final String title = "how to gain dominance among developers";

    @Before
    public void initEnv() {
        System.out.println("init");
        System.setProperty("webdriver.chrome.driver", "/Users/Volha_Tsiareshchanka/Desktop/drivers/Driver");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        PasteBinResults resultpage = new PasteBin(driver)
                .openPage()
                .setText(code)
                .setTitle(title)
                .setExpiration("10 Minutes")
                .setSyntax("Bash")
                .createNewPaste();

        Assert.assertTrue("Title contains proper text", resultpage.isTitleEquals(title));
        Assert.assertTrue("TextArea contains proper text", resultpage.isTextareaEquals(code));
        Assert.assertTrue("Expire Field contains proper text", resultpage.isExpireEquals("10 min"));
        Assert.assertTrue("Syntax Field contains proper text", resultpage.isSyntaxEquals("Bash"));
    }

    @After
    public void destroyEnv() {
        driver.quit();
    }
}

