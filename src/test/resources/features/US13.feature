
@US0013
Feature: US013 YT_Test_Results_Islemleri

  Background:

    Given YT Doktor url gider
    Then  YT Sing in tiklar
    And   YT Username ve Password ile giris yapar
    Then  YT My Pages Butonunu tiklar
    Then  YT My Appointments tiklar
    And   YT Hasta bilgileri icin edit tiklar


  Scenario: TC001_YT_Test_Results_ile_ilgili_alanlar_gorulebilmeli

    And  YT Guncellenen test sonuc icin Show Test Results tiklar
    And  YT Gelen sonuc icin View Results tiklar
    Then YT ilgili alanlar kontrol edilir


  Scenario: TC002_YT_Doktor_Request_Impatient_yapabilmeli

    Then YT Yatili hasta icin ilgili alanlar doldurulur
    And  YT Request Impatient tiklar
    Then YT Sayfayi kapatir
