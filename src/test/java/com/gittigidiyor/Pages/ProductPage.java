package com.gittigidiyor.Pages;

import com.gittigidiyor.Utilities.BrowserUtilities;
import com.gittigidiyor.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1[@id='sp-title']")
    public WebElement productInformation;

    @FindBy(xpath = "//button[@id='add-to-basket']")
    public WebElement addCartButton;

    @FindBy(css = "#price.gg-w-24 #sp-price-lowPrice")
    public WebElement productCost;

    @FindBy(css = "div.icon-sepet-line-wrapper")
    public WebElement myCart;


    public void createTxtFileAndWriteProductInfo() {

        String productName = productInformation.getText();
        String productPrice = productCost.getText();

        try {

            File myObj = new File("src/test/resources/info.txt");
            myObj.createNewFile();

            System.out.println("File created: " + myObj.getName());
            FileWriter writer = new FileWriter("src/test/resources/info.txt");

            writer.write("Product Name : " + productName);
            writer.write("Product Price : " + productPrice);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void productAddedCart(){
        BrowserUtilities.waitForClickability(addCartButton,5);
        addCartButton.click();
        BrowserUtilities.waitFor(3);
    }
}
