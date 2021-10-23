package com.gittigidiyor.Pages;

import com.gittigidiyor.Utilities.BrowserUtilities;
import com.gittigidiyor.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//div/strong)[1]")
    public WebElement priceOnCart;

    @FindBy(xpath = "//select[@class='amount']")
    public WebElement amountOfProduct;

    @FindBy(xpath = "//a[@title='Sil']")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[@class='gg-m-24 gg-t-9 gg-d-9 gg-w-9 toaster-msg']")
    public WebElement verifyThatDeletedProductButton;

    public void compareTheProductCost() {
        ProductPage productPage = new ProductPage();
        String PriceOnProductPage = productPage.productCost.getText().trim();
        BrowserUtilities.waitFor(2);
        productPage.myCart.click();

        CartPage cartPage = new CartPage();
        BrowserUtilities.waitForVisibility(cartPage.priceOnCart, 5);
        String PriceONCartPage = cartPage.priceOnCart.getText();

        Assert.assertEquals(PriceOnProductPage, PriceONCartPage);
    }

    public void changeAmountOfProduct(String amount) {
        Select dropdownElement = new Select(amountOfProduct);
        dropdownElement.selectByVisibleText(amount);

        BrowserUtilities.waitFor(2);
        Assert.assertEquals(amount, dropdownElement.getFirstSelectedOption().getText().trim());
    }

    public void deleteProductAndVerify(){
        deleteButton.click();
        BrowserUtilities.waitForVisibility(verifyThatDeletedProductButton,5);

    }
}
