
@US005 @run
Feature: Hastalar (patients), hastahaneden Mainpage-Appointment formu kullanarak randevu (Appointment) olusturabilmelidir

  Background:
    Given TY kullanici url'e gider
    Then TY kullanici Make an Appointment butonuna tiklar
    And TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir

    Scenario: TC08 Mainpage-Appointment formda Firstname textbox'i boş birakilmamalidir
      Then TY kullanici First Name kutusuna tiklar ve tab karakterine basar
      And TY kullanici Firstname'in altinda Your FirstName is required. yazisini gorur

    Scenario: TC09 Mainpage-Appointment formda Lastname textbox'i boş birakilmamalidir
      Given TY kullanici Last Name kutusuna tiklar ve tab karakterine basar
      Then TY kullanici Lastname'in altinda Your LastName is required. yazisini gorur

    Scenario: TC010 Mainpage-Appointment formda SSN textbox'i boş birakilmamalidir
      Given TY kullanici SSN kutusuna tiklar ve tab karakterine basar
      Then TY kullanici SSN'in altinda Your SSN is required. yazisini gorur

    Scenario: TC11 Mainpage-Appointment formda Email textbox'i boş birakilmamalidir
      Given TY kullanici Email kutusuna tiklar ve tab karakterine basar
      Then TY kullanici Email'in altinda Your email is required. yazisini gorur
      And TY kullanici @ ve . icermeyen gecersiz bir mail girer
      Then TY kullanici Email'in altinda This field is invalid yazisini gorur

    Scenario: TC12 Mainpage-Appointment formda Phone textbox'i boş birakilmamalidir
      Given TY kullanici Phone kutusuna tiklar ve tab karakterine basar
      Then TY kullanici Phone'in altinda Phone number is required. yazisini gorur

    Scenario Outline: TC13 Mainpage-Appointment formda Phone textbox'i invalid degerler ile doldurulmamalidir
      And TY kullanici phone textbox'ini invalid "<phone number>" ile doldurur ve invalid phone number uyarısı alır

      Examples:
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

    Scenario: TC14 Mainpage-Appointment form ile appointment olusturan kullanici daha sonra kayıt oldugunda randevusunu goruntuleyebilmelidir
      Given TY kullanici First Name kutusunu doldurur
      And TY kullanici Last Name kutusunu doldurur
      And TY kullanici SSN kutusunu doldurur
      And TY kullanici Email kutusunu valid bir deger ile doldurur
      And TY kullanici Phone kutusunu doldurur
      Then TY kullanici enter tusuna basar
      Then TY kullanici TY kullanici randevusunun olustugunu cikan popup ile dogrular
      When TY kullanici register butonuna tiklar ve randevu alirken kullandigi bilgiler ile formu doldurarak kayit olur
      Given TY kullanici signIn olur
      Then TY kullanici My Pages Butonuna Tiklar ve Menu'den My Appointment Secenegini Secer
      And TY kullanici randevusunun olustugunu dogrular
      # TY kullanıcı son randevu tarih/saati ile sistem tarih/saatini karsılastirarak  doğrular

