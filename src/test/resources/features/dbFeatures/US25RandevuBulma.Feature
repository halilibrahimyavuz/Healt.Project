@randevular
Feature: US 25 randevu


  Scenario: TC-01 randevu
    Given Kullanici  db ye baglanir
    Then  Kullanici select "*" from "appointment" sorgusu yapar
    And   Kullanici "id" sutununu okur
    Then  kullanici "appointment" table "id" sutunundaki "88514" dogrular
    Then sayfayi kapatir

