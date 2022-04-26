@RG
Feature:US25 Randevu Alma


  Scenario: TC_01 Giris yapilarak Randevu alma
     Given Patient URL sayfasina gider
     And   Patient insan ikonuna tiklar
     And   Patient   sign in sekmesine tiklar
     Then  Patient Username girer
     Then  Patient Password girer.
     And   Patient  signin butonuna tiklar
     Then  Patient giris yapilabiligini dogrular
     And   Patient My pages'e tiklar
     And   Patient Make an Appointment tiklar
     Then  Patient acilan sayfada bilgileri doldurur
     And   Patient  Send an Appointment Request tiklar
     Then  Patient randevu aldigini dogrular


    @TC--02
  Scenario Outline: TC02 Giris yapmadan Randevu alma
    Given Patient URL sayfasina gider
    And   Patient acilan sayfada Make an Appointment tiklar
    Then  Patient  firstname girer "<firstname>"
    Then  Patient  lastname girer  "<lastname>"
    Then  Patient ssn girer  "<Ssn>"
    Then  Patient  email girer  "<email>"
    Then  Patient phone girer "<phone>"
    Then  Patient Appointment DateTime girer "<DateTime>"
    Then  Patient girilen tarihle sistem tarihi ayni olmali
    Then Patient Tarih sirasi gun.ay.yil (ay.gun.yil) seklinde olmalidir
    And   Patient  Send an Appointment Request elementine tiklar
    Then  Patient randevu alabildigini dogrular

    Examples:
      |firstname|lastname|Ssn|email|phone|DateTime|
      |PatientMehmet|PatientMehmet|888-89-4090|PatientMehmet@medunna.com|333-565-2232|27-04-2022|