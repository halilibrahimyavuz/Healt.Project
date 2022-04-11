@US14
Feature: US14_Edit_Inpatient_Islemleri

  Scenario: TC01_BA_Physician_olarak_giris_yapar
    Given BA Physician medunna url gider
    And   BA Account butonuna tiklar
    And   BA Sign in butonuna tiklar
    And   BA Physician username ve password girer
    Then  BA Sign in butonuna tiklar ve giris yapar

  Scenario: TC02_BA_MyInpatients_sayfasinda_In_Patients_basligi_gorur
    When  BA MY PAGES butonuna tiklar
    And   BA My Inpatients butonuna tiklar
    Then  BA In Patients basligi gorulur

  Scenario: TC03_BA_ID_StartDate_EndDate_Status_CreatedDate_Room_AppointmentID_goruntuler
    And  BA DoctorID goruntuler
    And  BA StartDate goruntuler
    And  BA EndDate goruntuler
    And  BA Status durumunu goruntuler
    And  BA CreatedDate goruntuler
    And  BA Room bilgisini goruntuler
    And  BA AppointmentID goruntuler
    And  BA Patient bilgisini goruntuler

  Scenario: TC04_BA_Description_CreatedDate_Status_Room_guncellenir
    Then   BA Edit butonuna tiklar
    And   BA Description bolumunu gunceller
    And   BA Created Date bolumunu gunceller
    And   BA Status durumunu gunceller
    When  BA Room bolumu guncellenir


  Scenario: TC05_BA_Save_Butona_Tiklar_Yeni_Sayfa_Acar
    Then   BA Save butonuna tiklar
    Then   Ba Yeni giris yapmak icin sayfayi kapatir

  Scenario: TC06_BA_ID_StartDate_EndDate_Appointment_Patient_gunceller
    Given BA Create or edit sayfasinda ID StartDate EndDate Appointment Patient bolumunu gunceller
    Then  BA Sayfayi kapatir