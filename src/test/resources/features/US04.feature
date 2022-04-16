@US04
Feature: US_04 Giris Sayfası Testi


  Background:
    Given YE Kullanıcı "<medunnaUrl>" sayfasına gider
    Then YE Sing in butonuna tıklar ve giris sayfasına gider


  @ss1
  Scenario: TC_01 Gecrli kimlik bilgileri ile giris yapabilme
    Then YE Geçerli bir kullanıcı adı ve şifre girer ve Sing in butonuna tıklar
    And YE başarılı bir giriş yapabildiğini görür
    And singOut yapar ve sayfayı kapatır


  @ss2
  Scenario: TC_02 Remember me butonu testi
    And YE Remember me sçeneğini görebilir
    Then YE Remember me sçeneğine tıklayabilir

  @ss3
  Scenario: TC_03 Sifremi unuttum testi
    Then YE Did you forget your password? secenegini görür
    And YE butona tıkladığında Reset your password sayfanına gider

  @ss4
  Scenario: TC_04 Hesap olusturma secenegi
    And YE You don't have an account yet? Register a new account seçeneğini görebilmeli
    Then YE You don't have an account yet? butonuna tıkladığında ve Registration sayfasına gidebilmeli

  @ss5
  Scenario: TC_05 Cancel butonuile cikis
    And YE Cancel butonunu görebilmeli
    Then YE Cancel butonuna tıkladığında "Sing in" sayfasından çıkabilmeli
