Feature:US028 Admin olarak; Country oluşturma / Okuma ve Silme

  Scenario: TC01_Kullanıcı yeni bir ulke olusturabilir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sag ust kosesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG Admin username olarak "AdminUsernameTG" girer
    And TG Admin password olarak "AdminPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG Items&Titles dropdown menusune tıklar
    And TG Acilan menude Country secenegine tiklar"
    Then TG Create a new Country butonuna tıklar
    And TG Eklemek istedigi ülke ismini girer
    And TG Tarihi girer
    And TG Save butonuna basar
    And TG Ulke olusturulup olusturulmadıgını kontrol eder
    And TG sayfayi kapatir


  Scenario: TC02_Kullanıcı, ulkeye gore ilgili eyaletler veya sehirler olusturabilmelidir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sag üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG Admin username olarak "AdminUsernameTG" girer
    And TG Admin password olarak "AdminPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG Items&Titles dropdown menusune tıklar
    And TG Acilan menude State City secenegine tiklar
    Then TG Create a new State City butonuna tıklar
    And TG Eklemek istedigi State City ismini girer
    And TG Tarihi girer
    And TG Save butonuna basar
    And TG sayfayi kapatir


  Scenario: TC06_Kullanıcı ulkeleri silebilmelidir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sag üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG Admin username olarak "AdminUsernameTG" girer
    And TG Admin password olarak "AdminPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG Items&Titles dropdown menusune tıklar
    And TG Acilan menude Country secenegine tiklar"
    And TG Silmek istedigi Ulkenin yanindaki DELETE butonuna basar
    And TG Silme istegini onaylar
    And TG sayfayi kapatir