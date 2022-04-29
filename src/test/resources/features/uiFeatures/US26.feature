Feature: US026 İletişim Mesajı (Contact messages)

  Scenario Outline: TC01_Herhangi bir kullanıcı bilgi almak için "Contact portal" üzerinden istek gönderebilmeli.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sag üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG Admin username olarak "AdminUsernameTG" girer
    And TG Admin password olarak "AdminPasswordTG" girer
    And TG Sign in butonuna basar
    And TG Header bolumundeki CONTACT secenegine tiklar
    Then TG Sayfada yer alan "<Name>", "<Email>", "<Subject>", "<Message>" kisimlarini doldurabildigini test eder
    And TG Bilgileri girdikten sonra mesajı gonderebildigini test eder
    And TG sayfayi kapatir
    Examples:
      |Name  |Email                |Subject |Message |
      |Kenan |kenan11222@gmail.com |konusuz |merhaba |


  Scenario Outline: TC02_Kullanıcı "Name, Email, Subject, Message" bölümlerine data girebilmeli ve mesajını gönderebilmeli.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG Header bolumundeki CONTACT secenegine tiklar
    Then TG Sayfada yer alan "<Name>", "<Email>", "<Subject>", "<Message>" kisimlarini doldurabildigini test eder
    And TG Bilgileri girdikten sonra mesajı gonderebildigini test eder
    And TG sayfayi kapatir
    Examples:
      |Name  |Email                |Subject |Message |
      |Kenan |kenan11222@gmail.com |konusuz |merhaba |