#Feature:US 25 randevu
#  @randevular1234
#  Scenario:TC-01 randevu
#    Given Kullanici  db ye baglanir
#   Then  Kullanici select "*" from "appointment" sorgusu yapar
#    And   Kullanici "id" sutununu okur
#    Then  kullanici "appointment" table "id" sutunundaki "88514" dogrular
#    Then sayfayi kapatir

Feature: us25
  @tc25db
  Scenario: tc25
   Given Kullanici  db ye baglanir
   Then Kullanici select "*" from "appointment" sorgusu yapar
   And Kullanici "created_by" sutunu okur
   Then kullanici "appointment" table "created_by" sutunundaki "hellohelo123@medunna.com" dogrular