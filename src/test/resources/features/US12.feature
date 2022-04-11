Feature: US12 Physician (Doktor) test isteyebilmeli
  (My Appointments/Edit/Request A Test)

  Scenario: US12_TC01 Kullanıcı(Hasta) Ana Sayfadan
  Appointment bolumunden randevu olusturabilmeli

    Given EA Kullanici "medunna" anasayfaya gider
    Then EA Make an Appointment butonuna tıklar
    And EA FirstName TextBox doldurur
    Given EA LastName TextBox doldurur
    And EA SSN numarasi girer
    And EA Email adresi girer
    And EA Phone number girer
    And EA Appointment DateTime secer
    And EA Send an Appointment Request Butonuna tiklar
    And EA Hastanin randevu kaydi yapildigi dogrulanir
    And EA Kullanici sayfayi kapatir


  Scenario:US12_TC02 Kullanici Staff olarak oturum acabilmeli

    Given EA Kullanici "medunna" anasayfaya gider
    Then  EA Sag ust kosede bulunan icona tiklar
    Then  EA Sign-in butonuna tiklar
    Then  EA Kayitli  staff Username girer
    Then  EA Kayitli  staff Password girer
    Then  EA ikinci Sign-in butonuna tiklar
    Then  EA Staff olarak oturum acildigi dogrulanir
    Then  EA Kullanici sayfayi kapatir

  Scenario:US12_TC03 Staff olarak acilan oturumda MY_PAGES bolumunden, randevu alan
  hastanın atamasi kayitli doktora yapilabilmeli

    Given EA Kullanici "medunna" anasayfaya gider
    Then  EA Kullanici Staff olarak oturum acar
    Then  EA Kullanici(Staff) MyPages bolumune tiklar
    Then  EA Kullanici(Staff) Search Patient(Hasta arama) bolumune tiklar
    Then  EA Kullanici(Staff) Aradigi hastanin SSN numarasini Patient SSN bolunume girer
    Then  EA Kullanici(Staff) SSN numarasini girdigi hastanin satirindaki ShowAppointments butonuna tiklar
    Then  EA Kullanici(Staff) ShowAppointments butonuna tikladikdan sonra Edit butonuna tiklar
    Then  EA Kullanici(Staff) acilan status dropbox bolumunden pending kismini secer
    Then  EA Kullanici(Staff) acilan Physician dropbox bolumunden hastanin atanacagi doktoru secer
    Then  EA Kullanici(Staff) save butonuna tiklar
    Then  EA Hastanin ilgili  hastanin ilgili doktora atamasinin yapildigi test edilir
    Then  EA Kullanici sayfayi kapatir

  Scenario:US12_TC04 Atama yapilan doktor hesabi ile sisteme giris yapilabilmeli

    Given EA Kullanici "medunna" anasayfaya gider
    Given EA Sag ust kosede bulunan icona tiklar
    Then EA Sign-in butonuna tiklar
    Then EA Kayitli doktor username girer
    Then EA Kayitli doktor password girer
    Then EA ikinci Sign-in butonuna tiklar
    And  EA Doktor olarak oturum acildigi dogrulanir
    Then  EA Kullanici sayfayi kapatir

  Scenario:US12_TC05 Doktor randevu alan hastadan test isteyebilmeli

    Given EA Kullanici "medunna" anasayfaya gider
    Then  EA Kullanici Doktor olarak oturum acar
    Given EA Kullanici(Doktor) MyPages bolumune tiklar
    Then  EA MyAppointment bolumune tiklar
    Then  EA Kendisinden randevu alan hasta adi ile ayni satirda bulunan Edit bolumune tiklar
    Then EA Create  or Edit an Appointment yazisinin gorunurlugu dogrulanir
    Then EA Kullanici(Doktor) Request A Test bolumune tiklar
    Then  EA Test Items yazisinin gorunurlugu dogrulanir
    Then  EA Kullanici sayfayi kapatir

  Scenario:US12_TC06 Doktor randevu alan hastadan "Glucose, Urea, Creatinine, Sodium
  Potassium, Total protein, Albumin, Hemoglobin"  testlerini isteyebilmeli
    Given EA Kullanici "medunna" anasayfaya gider
    Then  EA Kullanici Doktor olarak oturum acar
    Given EA Kullanici(Doktor) MyPages bolumune tiklar
    Then  EA MyAppointment bolumune tiklar
    Then  EA Kendisinden randevu alan hasta adi ile ayni satirda bulunan Edit bolumune tiklar
    Then EA Kullanici(Doktor) Request A Test bolumune tiklar
    And EA Urea testi secer
    And EA Creatinine testi secer
    And EA Sodium testi secer
    And EA Potassium testi secer
    And EA Total protein	 testi secer
    And EA Hemoglobin testi secer
    And EA Albumin testi secer
    And EA Glucose testi secer
    Then EA Save  butonuna tiklar
    And EA Testlerin kaydedildigi kontrol edilir
    Then  EA Kullanici sayfayi kapatir


