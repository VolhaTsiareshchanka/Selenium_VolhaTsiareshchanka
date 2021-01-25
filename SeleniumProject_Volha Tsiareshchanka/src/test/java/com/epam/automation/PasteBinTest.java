package com.epam.automation;


import com.epam.automation.pages.PasteBin;
import com.epam.automation.pages.PasteBinResults;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PasteBinTest
{

    private WebDriver driver;

    @Before
    public void initEnv() {
        System.out.println("init");
        System.setProperty("webdriver.chrome.driver", "/Users/Volha_Tsiareshchanka/Desktop/drivers/Driver");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        //driver.get("https://pastebin.com");
        PasteBinResults resultpage = new PasteBin(driver)
                .openPage()
                .setText("Hello from WebDriver")
                .setTitle("helloweb")
                .setExpiration("10 Minutes")
                .createNewPaste();

        Assert.assertTrue("Title contains proper text", resultpage.isTitleEquals("helloweb"));
        Assert.assertTrue("TextArea contains proper text", resultpage.isTextareaEquals("Hello from WebDriver"));
        Assert.assertTrue("Expire Field contains proper text", resultpage.isExpireEquals("10 min"));}

    @After
    public void destroyEnv() {
        driver.quit();
    }
}
