package com.gittigidiyor.Pages;

import com.gittigidiyor.Utilities.BrowserUtilities;
import com.gittigidiyor.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@data-cy='pageinfo']/../div[3]//li")
    public List<WebElement> productList;


    public void clickPageNumber(int number) {
        WebElement pageNum = Driver.get().findElement(By.xpath("//li[@data-testid][" + number + "]//span"));
        BrowserUtilities.scrollToElement(pageNum);
        BrowserUtilities.waitForClickability(pageNum, 3);
        pageNum.click();
    }

    public void verifyPageNumber(Integer pageNum) {
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertTrue(currentUrl.endsWith(String.valueOf(pageNum)));
    }

    public void refreshPage() {
        try {
            if (pageNotFoundError.getText().equals("Sayfa Bulunamadı.")) {
                Driver.get().navigate().refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOneOfTheProduct() {
        BrowserUtilities.waitFor(5);
        Random random = new Random();
        int randomProduct = random.nextInt(productList.size());
        BrowserUtilities.waitFor(2);
        productList.get(randomProduct).click();
    }


}
