
@US07 @run
Feature: Mainpage-Appointment form uzerinden hastalar randevu tarihi olusturabilmelidir

  Background:
    Given TY kullanici url'e gider
    Then TY kullanici Make an Appointment butonuna tiklar
    And TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    And TY kullanici First Name kutusunu doldurur
    And TY kullanici Last Name kutusunu doldurur
    And TY kullanici SSN kutusunu doldurur
    And TY kullanici Email kutusunu valid bir deger ile doldurur
    Then TY kullanici phone textbox'ini valid bir deger ile doldurur


  Scenario: US06 Mainpage-Appointment formda date bos birakilabilmelidir
    #Given TY kullanici url'e gider
    #Then TY kullanici Make an Appointment butonuna tiklar
    #And TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And TY kullanici First Name kutusunu doldurur
    #And TY kullanici Last Name kutusunu doldurur
    #And TY kullanici SSN kutusunu doldurur
    #And TY kullanici Email kutusunu valid bir deger ile doldurur
    #Then TY kullanici phone textbox'ini valid bir deger ile doldurur
    Then TY kullanici date textbox'inda yer alan tarihin sistem tarihi ile ayni oldugunu dogrular
    And TY kullanici Send an Appointment Request butonunu tiklar
    And TY kullanici TY kullanici randevusunun olustugunu cikan popup ile dogrular

  Scenario: US07 Mainpage-Appointment formda date alani icin gecmis tarih secildiginde randevu olusturulmamalidir
    #Given TY kullanici url'e gider
    #Then TY kullanici Make an Appointment butonuna tiklar
    #And TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And TY kullanici First Name kutusunu doldurur
    #And TY kullanici Last Name kutusunu doldurur
    #And TY kullanici SSN kutusunu doldurur
    #And TY kullanici Email kutusunu valid bir deger ile doldurur
    #Then TY kullanici phone textbox'ini valid bir deger ile doldurur
    And TY kullanici date textbox'ini gecmis bir tarih ile doldurur
    Then TY kullanici date textboxinin altinda Appointment date can not be past date! uyarisinin gorundugunu dogrular
    And TY kullanici Send an Appointment Request butonunu tiklar
    Then TY kullanici randevunun basarili bir sekilde kaydedilemedigini cikan popup ile dogrular

  Scenario: US08 Mainpage-Appointment formda date alani icin ileri tarihli valid bir deger secildiginde randevu olusturulmamalidir
    #Given TY kullanici url'e gider
    #Then TY kullanici Make an Appointment butonuna tiklar
    #And TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And TY kullanici First Name kutusunu doldurur
    #And TY kullanici Last Name kutusunu doldurur
    #And TY kullanici SSN kutusunu doldurur
    #And TY kullanici Email kutusunu valid bir deger ile doldurur
    #And TY kullanici phone textbox'ini valid bir deger ile doldurur
    Then TY kullanici date textbox'ini valid bir deger ile doldurur ve Send An Appointment butonuna basar
    And TY kullanici TY kullanici randevusunun olustugunu cikan popup ile dogrular

  Scenario Outline: US09 Mainpage-Appointment formda date alani gg/aa/yy formatina uygun olarak doldurulmalidir
    #Given TY kullanici url'e gider
    #Then TY kullanici Make an Appointment butonuna tiklar
    #And TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And TY kullanici First Name kutusunu doldurur
    #And TY kullanici Last Name kutusunu doldurur
    #And TY kullanici SSN kutusunu doldurur
    #And TY kullanici Email kutusunu valid bir deger ile doldurur
    #And TY kullanici phone textbox'ini valid bir deger ile doldurur
    Then TY kullanici date textbox'ini "<date>" ile doldurur ve date alaninda yazan tarihin ayni oldugunu dogrular

    Examples:
      | date |
      |01.01.2030|
      |31.01.2030|
      |01.12.2039|

  Scenario Outline: US10 Mainpage-Appointment formda date alani aa/gg/yy formatina uygun olarak dolduramamalidir
    #Given TY kullanici url'e gider
    #Then TY kullanici Make an Appointment butonuna tiklar
    #And TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir
    #And TY kullanici First Name kutusunu doldurur
    #And TY kullanici Last Name kutusunu doldurur
    #And TY kullanici SSN kutusunu doldurur
    #And TY kullanici Email kutusunu valid bir deger ile doldurur
    #And TY kullanici phone textbox'ini valid bir deger ile doldurur
    Then TY kullanici date textbox'ini "<date>" ile doldurur ve date alaninda yazan tarihin ayni olmadigini dogrular

    Examples:
      | date |
      |12.13.2030|
      |01.31.2030|