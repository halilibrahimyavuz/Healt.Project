Feature: Kullanici DB ile mesajlari dogrulamalidir

  Scenario Outline: TC01 Message Bilgilerini Okuma ve Dogrulama
    Given TY Kullanici Database Ile Baglanti Kurar
    Then  TY Kullanici "<table>" Tablosundan "<selectRow>" Satirlarini Getirir
    And   TY Kullanici "<table>" Tablosunun "<column>" Sutununun "<columnData>" Icerdigini Dogrular
    Then  TY Kullanici "<id>" ye Sahip Datanin "cmessage" cmessage Tablosundaki Bilgilerini Kaydeder Ve Dogrular
    #Then  TY Kullanici "<id>" ye Sahip Datanin "<table>" Tablosundaki "<column>" Sutunundaki Bilgilerini Kaydeder Ve Dogrular
    And   TY Kullanici Database Baglantisini Kapatir

    Examples:
      |id   |table    |column   |columnData      |selectRow|
      |88966|cmessage |name     |Test Datasi-Name|*        |
