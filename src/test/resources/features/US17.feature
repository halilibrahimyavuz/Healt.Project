@testItem
Feature: US17 Test-Item olustur,düzenle ve sil

  Background:
    Given YE Kullanıcı "<medunnaUrl>" sayfasına gider
    Then YE Sing in butonuna tıklar ve giriş sayfasına gider
    And YE Geçerli bir kullanıcı adı ve password girer ve Admin kullanıcı sayfasına ulaşır
    Then YE Items-Titles menusu altında Test Item a tıklar

  @tc1-17
  Scenario Outline: TC01
    And YE Create a new Test Item butonuna tıklar ve Create or edit a Test Item sayfasına ulaşır
    Then YE İstenen "<name>", "<description>", "<price>", "<defaultValMin>", "<defaultValMax>" dataları girer ve Save butonuna tıklar
    And YE kayıt yaptiğini test eder

    Examples:
      |name   |description |price|defaultValMin|defaultValMax|
      |kan7   |serum       |45   |67           |86           |

  @tc2-17
  Scenario: TC02
    And YE Verilen ID li kaydı bulur ve View butonuna tıkla
    Then YE Test-Item i görüntüleyebildiğini test eder.

  @tc3-17
  Scenario: TC03
    And YE  Edit butonuna tıklar
    Then YE Verileri dataları değiştirir ve Save butonuna basar
    And YE kaydı güncelleyebildiğini test eder



  @tc4-17
  Scenario: TC04
    And YE Verilen ID li kaydı bulur ve Delete butonuna tıkla
    Then YE mevcut kaydı sildiğini test eder
