Feature:

  @wip
  Scenario: Gittigidiyor.com üzerinde selenium Web Otomasyonu


    Given www.gittigidiyor.com sitesi açılır.
    And Arama kutucuğuna "bilgisayar" kelimesi girilir.
    When Arama sonuçları sayfasından 2. sayfa açılır.
    And 2.sayfanın açıldığı kontrol edilir.
    Then Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
    And Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
    Then Seçilen ürün sepete eklenir.
    And Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
    And Adet arttırılarak ürün adedinin "2" olduğu doğrulanır.
    And Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.