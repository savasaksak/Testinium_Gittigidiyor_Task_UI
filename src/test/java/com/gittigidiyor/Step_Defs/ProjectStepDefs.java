package com.gittigidiyor.Step_Defs;

import com.gittigidiyor.Pages.CartPage;
import com.gittigidiyor.Pages.DashboardPage;
import com.gittigidiyor.Pages.ProductPage;
import com.gittigidiyor.Pages.SearchPage;
import com.gittigidiyor.Utilities.BrowserUtilities;
import com.gittigidiyor.Utilities.Driver;
import com.gittigidiyor.Utilities.Log4j;
import com.gittigidiyor.Utilities.ReaderConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectStepDefs {

    @Given("www.gittigidiyor.com sitesi açılır.")
    public void www_gittigidiyor_com_sitesi_açılır() {
        Driver.get().get(ReaderConfig.get("url"));
        Log4j.info("Opening Page of the Gittigidiyor");
    }

    @Given("Arama kutucuğuna {string} kelimesi girilir.")
    public void arama_kutucuğuna_kelimesi_girilir(String productName) {
        DashboardPage dashboardPage = new DashboardPage();
        BrowserUtilities.waitFor(3);

        dashboardPage.searchProduct(productName);
        Log4j.info("Keşfetmeye bak kutusuna " + productName + " kelimesi gönderilir");


    }

    @When("Arama sonuçları sayfasından {int}. sayfa açılır.")
    public void arama_sonuçları_sayfasından_sayfa_açılır(Integer pageNumber) {
        SearchPage searchPage = new SearchPage();
        searchPage.clickPageNumber(pageNumber);
        Log4j.info("Arama sonuçları sayfasında " + pageNumber + ". sayfaya tıklanır.");
        searchPage.refreshPage();

    }

    @When("{int}.sayfanın açıldığı kontrol edilir.")
    public void sayfanın_açıldığı_kontrol_edilir(Integer pageNum) {
        SearchPage searchPage = new SearchPage();
        searchPage.verifyPageNumber(pageNum);
        Log4j.info("Açılan sayfanın kontrolü yapılır");
    }

    @Then("Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.")
    public void sonuca_göre_sergilenen_ürünlerden_rastgele_bir_ürün_seçilir() {
        SearchPage searchPage = new SearchPage();
        searchPage.clickOneOfTheProduct();
        Log4j.info("Sayfada bulunan ürünlerden rastgele birisine tıklanır.");
    }

    @Then("Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.")
    public void seçilen_ürünün_ürün_bilgisi_ve_tutar_bilgisi_txt_dosyasına_yazılır() {
        ProductPage productPage = new ProductPage();
        productPage.createTxtFileAndWriteProductInfo();
        Log4j.info("Seçilen ürünün, ürün bilgisi ve fiyat bilgisi txt dosyasına yazdırılır.");

    }

    @Then("Seçilen ürün sepete eklenir.")
    public void seçilen_ürün_sepete_eklenir() {
        ProductPage productPage = new ProductPage();
        productPage.productAddedCart();
        Log4j.info("Seçilen ürün sepete eklenir.");
    }

    @Then("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.")
    public void ürün_sayfasındaki_fiyat_ile_sepette_yer_alan_ürün_fiyatının_doğruluğu_karşılaştırılır() {
        CartPage cartPage = new CartPage();
        cartPage.compareTheProductCost();
        Log4j.info("Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.");

    }

    @Then("Adet arttırılarak ürün adedinin {string} olduğu doğrulanır.")
    public void adet_arttırılarak_ürün_adedinin_olduğu_doğrulanır(String amount) {
        CartPage cartPage = new CartPage();
        cartPage.changeAmountOfProduct(amount);
        Log4j.info("Adet arttırılarak ürün adedinin " + amount + " olduğu doğrulanır.");

    }

    @Then("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.")
    public void ürün_sepetten_silinerek_sepetin_boş_olduğu_kontrol_edilir() {
        CartPage cartPage = new CartPage();
        cartPage.deleteProductAndVerify();
        Log4j.info("Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.");
    }
}
