@US03
Feature: US_03 Registration Password


  Background:
    Given YE Kullanıcı "<medunnaUrl>" sayfasına gider
    Then YE Registration butonuna tıklar vekayıt sayfasına gider

  @tc1
  Scenario: TC_01 4 haneli Password testi
    Then YE tek haneli şifre  girer ve yeterli uzunlukta olmadığını görür
    And YE iki haneli şifre  girer ve yeterli uzunlukta olmadığını görür
    And YE üç haneli şifre  girer ve yeterli uzunlukta olmadığını görür
    Then YE 4 haneli şifre  girer ve kabul edildiğini görür

  @tc2
  Scenario: TC_02 Güçlü password testi
    Then YE İçerisinde bir küçük harf olan enaz yedi haneli password girer
    And YE Password strength seviyesinin değiştiğini görür

  @tc3
  Scenario: TC_03 Güçlü password testi
    Then YE İçerisinde bir küçük bir büyük harf olan 7 haneli password girer
    And YE Password strength seviyesinin değiştiğini görür

  @tc4
  Scenario: TC_04 Güçlü password testi
    Then YE İçerisinde bir büyük bir küçük ve rakam harf olan enaz yedi haneli password girer
    And YE Password strength seviyesinin değiştiğini görür

  @tc5
  Scenario: TC_05 Güçlü password testi
    Then YE İçerisinde bir büyük bir küçük rakam harf ve ozel karakter olan enaz yedi haneli password girer
    And YE Password strength seviyesinin değiştiğini görür

  @tc6
  Scenario: TC_06 Space tuşu ile Güçlü Password oluşturulabilir
    Then YE Registration butonuna tıklar vekayıt sayfasına gider
    Then YE Password olarak sürekli space tuşuna basar
    And YE Password strength seviyesinin değiştiğini görür fakat password olarak kabul etmez

