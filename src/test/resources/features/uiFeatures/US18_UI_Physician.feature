
@US0018

Feature:
  Background:
    Given BA Medunna url gider
    And   BA Account menu tiklar
    And   BA Sign in Enter tiklar
    And   BA Admin Username girer
    And   BA Admin Password girer
    When  BA Sign in Enter tiklar Admin olarak giris yapar
    Then  BA Items Titles butona tiklar
    And   BA Physician butonuna tiklar



  Scenario: TC_0001 Admin_BA_SSN_kimligine_gore_kisi_secer_veya_arayabilir
    And   BA Create a new Physician  butonuna tiklar
    And   BA Use Search butonuna tiklar
    Then  BA Kayitli SSN girer
    When  BA Search User butonuna tiklar
    Then  BA User Found mesajini gorur

  Scenario: TC_0002 Admin_BA_firstname_lastname_birthdate_phone_number_bilgilerini_doldurabilir
    And   BA Create a new Physician  butonuna tiklar
    Given BA Firstname girer
    And   BA Lastname girer
    And   BA Birthdate girer
    Then  BA Phone number girer

  Scenario: TC_0003 Admin_BA_doktor_icin_uzmanlik_alani_secebilir
    And   BA Create a new Physician  butonuna tiklar
    Given BA Doktor icin uzmanlik alani secer

  Scenario: TC_0004 Admin_BA_doktorun_profil_resmini_yukleyebilir
    And   BA Create a new Physician  butonuna tiklar
    Given BA Doktorun profil resmini yukler

  Scenario: TC_0005 Admin_doktorun_muayene_ucretini_girmelidir
    And   BA Create a new Physician  butonuna tiklar
    Given BA Doktorun muayene ucretini girer.

  Scenario: TC_0006 Admin_mevcut_kullanicilar_arasindan_doktoru_secebilir
    And   BA Create a new Physician  butonuna tiklar
    Given BA Kayitli kullanicilar arasindan doktoru secer

  Scenario: TC_0007 Admin_BA_butun_doktorlarin_bilgilerini_gorebilir.
    Given BA Doktorlarin bilgilerini gorur

  Scenario: TC_0008 Admin_BA_doktorlarin_bilgilerini_duzenleyebilir
    And   BA Doktorun bilgisini duzenlemek icin Edit butona tiklar

  Scenario: TC_0009 Admin_BA_mevcut_doktorlari_silebilir.
    Then  BA Mevcut  doktoru siler


