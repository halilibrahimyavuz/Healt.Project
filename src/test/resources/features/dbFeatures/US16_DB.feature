Feature: DB ile oda bilgilerini dogrulayin
  # feature seviyesinden calistirinca stepleri gormuyor !!!


  Scenario Outline: TC01 Oda Bilgilerini Okuma ve Dogrulama
    Given TY Kullanici Database Ile Baglanti Kurar
    Then  TY Kullanici "<table>" Tablosundan "<selectRow>" Satirlarini Getirir
    And   TY Kullanici "room" Tablosunun "<column>" Sutununun "<columnData>" Icerdigini Dogrular
    Then  TY Kullanici "<id>" ye Sahip Datanin "room" Tablosundaki Bilgilerini Kaydeder Ve Dogrular
    #Then  TY Kullanici "<id>" ye Sahip Datanin "room" Tablosundaki "<column>" Sutunundaki Bilgilerini Kaydeder Ve Dogrular
    And   TY Kullanici Database Baglantisini Kapatir

    Examples:
      |id     |table|column   |columnData     |selectRow|
      |89576  |room |room_type|PREMIUM_DELUXE |*        |



