package com.gittigidiyor.Pages;

import com.gittigidiyor.Utilities.BrowserUtilities;
import com.gittigidiyor.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@data-cy='header-search-input']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@data-cy='search-find-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[.='Kapat']")
    public WebElement closeCookies;

    @FindBy(xpath = "//h1[.='Sayfa Bulunamadı.']")
    public WebElement pageNotFoundError;

    public void searchProduct(String productName){
        BrowserUtilities.waitForClickability(searchBox, 5);
        closeCookies.click();
        searchBox.click();
        searchBox.sendKeys(productName);
        searchButton.click();
    }

}
