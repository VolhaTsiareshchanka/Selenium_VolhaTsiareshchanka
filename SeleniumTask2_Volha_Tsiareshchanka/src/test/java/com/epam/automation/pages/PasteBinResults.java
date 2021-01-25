package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinResults
    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement title;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement textarea;

    @FindBy(xpath = "//div[@class='expire']")
    private WebElement expire;

    @FindBy(xpath ="//div[@class='highlighted-code']/descendant::a")
    private WebElement syntax;

    private WebDriver driver;

    public PasteBinResults(WebDriver driver) {
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='info-top']/h1")));
        this.driver = driver;
    }

    public boolean isTitleEquals(String text) {
        return title.getText().equals(text);
    }

    public boolean isTextareaEquals(String text) {
        return textarea.getText().equals(text);
    }

    public boolean isExpireEquals(String text) {
        return expire.getText().equals(text.toUpperCase());
    }

    public boolean isSyntaxEquals(String text) {
        return syntax.getText().equals(text);
    }

}
