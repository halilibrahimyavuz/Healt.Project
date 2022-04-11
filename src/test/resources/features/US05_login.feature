
@US005 @run
Feature: Hastalar (patients), hastahaneden Login-Appointment formu kullanarak randevu (Appointment) olusturabilmelidir

  #Background:
   # Given TY kullanici signIn olur
    #Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer

  Scenario: TC01 Login-Appointment formda yazan First Name, User First Name ile ayni olmalidir
    Given TY kullanici signIn olur
    Then TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And TY First Name Textbox'inda Yazan Kullanici Adi ile Login Islemini Gerceklestiren Kullanici Adinin Ayni Oldugu Test Edilir

  Scenario: TC02 Login-Appointment formda yazan Last Name, User Last Name ile ayni olmalidir
    Given TY kullanici signIn olur
    Then TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    Given TY Last Name Textbox'inda Yazan Kullanici Adi ile Login Islemini Gerceklestiren Kullanici Soyadinin Ayni Oldugu Test Edilir

  Scenario: TC03 Login-Appointment formda yazan SSN, User SSN ile ayni olmalidir
    Given TY kullanici signIn olur
    Then TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    Given TY SSN Textbox'inda Yazan SSN ile Login Islemini Gerceklestiren Kullanici SSN bilgisinin Ayni Oldugu Test Edilir

  Scenario: TC04 Login-Appointment formda yazan e-mail, User e-mail ile ayni olmalidir
    Given TY kullanici signIn olur
    Then TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    Given TY email Textbox'inda Yazan email ile Login Islemini Gerceklestiren Kullanici email bilgisinin Ayni Oldugu Test Edilir

  Scenario Outline: TC05 Login-Appointment formda phone number invalid degerler ile doldurulmamalidir
    Given TY kullanici signIn olur
    Then TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And TY kullanici phone textbox'ini invalid "<phone number>" ile doldurur ve invalid phone number uyarısı alır

     Examples:
       |phone number|
       |phone number|
       |111-111-111|
       |111-111-11111|
       |1111111111|
       |111-1111111|
       |111 111 1111|
       |111 1111111|
       |111111 1111|
       |111-111 1111|
       |111 111-1111|
    # 1) invalid-9 karakter
    # 2) invalid-11 karakter
    # 3) invalid-10 karakter, -'siz

  Scenario: TC06 Login-Appointment formda phone number bos birakilmamali ve valid bir deger ile doldurulmalidir
    Given TY kullanici signOut olur
    Given TY kullanici signIn olur
    Then TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    And TY kullanici phone textbox'ini bos birakir ve Phone number is required uyarisini alir
    And TY kullanici phone textbox'ini valid bir deger ile doldurur ve Send An Appointment butonuna basar
    Then TY kullanici randevunun basarili bir sekilde kaydedildigini cikan popup ile dogrular


  Scenario: TC07 Login-Appointment olustuktan sonra kullanici olusturdugu randevusunu goruntuleyebilmelidir
    Given TY kullanici signIn olur
    Then TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular
    Then TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer
    Given TY kullanici My Pages Butonuna Tiklar ve Menu'den My Appointment Secenegini Secer
    Then TY kullanici randevusunun olustugunu dogrular
    # TY kullanıcı son randevu tarih/saati ile sistem tarih/saatini karsılastirarak  doğrular
