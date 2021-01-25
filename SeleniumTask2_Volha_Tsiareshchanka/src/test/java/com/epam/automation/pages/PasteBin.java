package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBin {
    @FindBy(id = "postform-text")
    private WebElement mainTextField;

    @FindBy(id = "postform-name")
    private WebElement title;

    @FindBy(id = "postform-expiration")
    private WebElement expiration;

    @FindBy(id = "postform-format")
    private WebElement syntax;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createButton;

    private WebDriver driver;

    public PasteBin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PasteBin openPage() {
        driver.get("https://pastebin.com");

        return this;
    }

    public PasteBin setText(String text) {
        mainTextField.sendKeys(text);
        return this;
    }

    public PasteBinResults createNewPaste() {
        createButton.click();
        return new PasteBinResults(driver);
    }

    public PasteBin setTitle(String text) {
        title.sendKeys(text);
        return this;
    }

    public PasteBin setExpiration(String text) {
        Select expirationSelect = new Select(expiration);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('postform-expiration').setAttribute('hidden', 'false')");
        js.executeScript("document.getElementById('postform-expiration').setAttribute('style', '')");
        expirationSelect.selectByVisibleText(text);
        return this;
    }

    public PasteBin setSyntax(String text) {
        Select syntaxSelect = new Select(syntax);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('postform-format').setAttribute('hidden', 'false')");
        js.executeScript("document.getElementById('postform-format').setAttribute('style', '')");
        syntaxSelect.selectByVisibleText(text);
        return this;
    }
}

