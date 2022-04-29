Feature: Staff hastalar icin randevulari gorur

  Scenario:TC01 Staff sadece randevulari guncelleyebilir.

    Given URL adresine gidilir
    Then Staff olarak giris yapilir.
    Then My Pages dropdown'u click yapilir
    Then Search Patient click yapilir.
    Then Patient SSN: kismina patient SSN yazilir
    Then Editclick yapilir
    Then Hasta bilgilerinde degisiklik yapilip,SAVE yapilir
    Then Hasta bilgilerinde degisiklik olmadigi gorulur
    Then My Pages dropdown'u click yapilir
    Then Search Patient click yapilir.
    Then Patient SSN: kismina patient SSN yazilir
    Then Show Appointments click yapilir
    Then Edit click yapilir
    Then Randevu bilgilerinde degisiklik yapilip SAVE yapilir
    And Randevu bilgilerinde degisikliklerin oldugu gorulur
    And Sayfa kapatilir

  Scenario:TC02 Staff hasta durumunu (status) "UNAPPROVED, PENDING veya CANCELLED" yapabilmeli ancak "COMPLETED" yapamamalı.

    Given URL adresine gidilir
    Then Staff olarak giris yapilir.
    Then My Pages dropdown'u click yapilir
    Then Search Patient click yapilir.
    Then Patient SSN: kismina patient SSN yazilir
    Then Show Appointments click yapilir
    Then Edit click yapilir
    Then Status seceneginin UNAPPROVED oldugu gorulmelidir
    Then Status seceneginin PENDİNG  secilmelidir ve  doktor ataması yapilip SAVE yapilmalidir.Status seceneginin PENDİNG oldugu gorulmelidir
    Then Status seceneginin COMPLETED  secilmemelidir ve SAVE yapilmalidir. Status seceneginin COMPLETED olmadigi gorulmelidir
    And  Status seceneginin CANCELLED  secilmelidir ve SAVE yapilmalidir.Status seceneginin CANCELLED oldugu gorulmelidir
    And Sayfa kapatilir

    Scenario:TC03 "Staff ""Anamnesis (Hastalık Geçmişi), Treatment ( Tedavi) veya Diagnosis(Teşhis)"" kısımlarına

      Given URL adresine gidilir
      Then Staff olarak giris yapilir.
      Then My Pages dropdown'u click yapilir
      Then Search Patient click yapilir.
      Then Patient SSN: kismina patient SSN yazilir
      Then Show Appointments click yapilir
      Then Edit click yapilir
      Then Anamnesis,Treatment,Diagnosis kisimlarina bilgi girilip,"SAVE"yapilmalidir.
      Then Anamnesis,Treatment,Diagnosis kisimlarina bilgi girilmedigi gorulmelidir
      And Sayfa kapatilir

  Scenario:TC04 Hasta için gerekli doktoru seçebilmeli ve randevuyu oluşturmalı.

    Given URL adresine gidilir
    Then Staff olarak giris yapilir.
    Then My Pages dropdown'u click yapilir
    Then Search Patient click yapilir.
    Then Patient SSN: kismina patient SSN yazilir
    Then Show Appointments click yapilir
    Then Edit click yapilir
    Then "Physician" kismindan doktor secilmelidir ve "SAVE" yapilmalidir
    Then Randevunun olustugu  gorulmelidir
    And  Sayfa kapatilir