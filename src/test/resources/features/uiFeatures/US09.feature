Feature: US009 Staff (Personel), hasta bilgilerini görebilmeli, düzenleyebilmeli ve silebilmelidir


  Scenario: TC01_Staff My Pages sekmesinden hasta bilgilerini görebilmelidir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sağ üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG username olarak "StaffUsernameTG" girer
    And TG password olarak "StaffPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG MYPAGES dropdown menusune tıklar
    And TG Search Patient butonuna tıklar
    Then TG Patients tablosunun ve hasta bilgilerinin gorunur oldugunu test eder
    And TG sayfayi kapatir


  Scenario: TC02_Staff bütün hasta bilgilerini düzenleyebilmelidir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sağ üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG username olarak "StaffUsernameTG" girer
    And TG password olarak "StaffPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG MYPAGES dropdown menusune tıklar
    And TG Search Patient butonuna tıklar
    Then TG Tabloda bilgilerini düzenlenmek istedigi hastanın yanındaki edit butonuna tıklar
    And TG Hasta bilgilerinin düzenlenebilir oldugunu test eder
    And TG sayfayi kapatir


  Scenario: TC03_Staff, SSN'lerine göre yeni bir başvuru sahibi arayabilmeli ve tüm kayıt bilgilerinin doldurulduğunu görebilmelidir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sağ üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG username olarak "StaffUsernameTG" girer
    And TG password olarak "StaffPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG MYPAGES dropdown menusune tıklar
    And TG Search Patient butonuna tıklar
    And TG Patient SSN kısmına hastanın SSN bilgisini girer
    Then TG Ilgili hastanın yanındaki view butonuna tıklar
    And TG kayit bilgilerinin gorunur oldugunu test eder
    And TG sayfayi kapatir


  Scenario: TC04_Staff herhangi bir hasta bilgisini silebilir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sağ üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG username olarak "StaffUsernameTG" girer
    And TG password olarak "StaffPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG MYPAGES dropdown menusune tıklar
    And TG Search Patient butonuna tıklar
    Then TG Tabloda bilgilerini düzenlenmek istedigi hastanın yanındaki edit butonuna tıklar
    And TG 1 saniye bekler
    And TG kayit bilgilerini siler ve Save butonuna tıklar
    And TG bilgilerin silinip silinmedigini test eder
    And TG sayfayi kapatir


  Scenario: TC05_Staff hastaları silememelidir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sağ üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG username olarak "StaffUsernameTG" girer
    And TG password olarak "StaffPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG MYPAGES dropdown menusune tıklar
    And TG Search Patient butonuna tıklar
    Then TG Tabloda bilgilerini düzenlenmek istedigi hastanın yanındaki edit butonuna tıklar
    And TG Hasta idsini silemedigini test eder
    And TG sayfayi kapatir


  Scenario: TC06_Staff hastaları SSN kimliklerine göre arayabilmelidir.
    Given TG kullanici "MedunnaUrl" sayfasina gider
    And TG sayfanin sağ üst köşesinde yeralan insan ikonuna tıklar
    Then TG acilan dropdown menude Sign in butonuna tıklar
    And TG username olarak "StaffUsernameTG" girer
    And TG password olarak "StaffPasswordTG" girer
    And TG Sign in butonuna basar
    Then TG MYPAGES dropdown menusune tıklar
    And TG Search Patient butonuna tıklar
    And TG Patient SSN kısmına hastanın SSN bilgisini girer
    And TG Arama yapabildigini ve istenilen hastanın gorunur oldugunu test eder
    And TG sayfayi kapatir