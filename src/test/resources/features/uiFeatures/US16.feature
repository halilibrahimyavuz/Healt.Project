
@dryrun
Feature: Admin Olarak Oda Olusturma / Goruntuleme / Guncelleme /Silme

  Background:
    Given TY Kullanici URL Adresine Gider ve Admin Olarak Sign In Olur
    Then TY Kullanici Sign-In Isleminin Basarili Olarak Gerceklestigini Dogrular
    Then TY Kullanici Navigation Bar'dan Items&Titles'a Tiklar
    Then TY Kullanici Acilan Dropdown Menuden 'Room' Secenegine Tiklar
    And TY Kullanici Rooms Sayfasinin Acildigini Dogrular


  Scenario: TC01 Admin, yatan hastalar icin yeni oda olusturabilir.
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    And TY Kullanici Room Type Secer
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    And TY Kullanici Description TextBox'ina Tiklar Ve 255'den Daha Az Sayida Karakter Iceren Bir Metin Girer
    And TY Kullanici Create Date Alanini 'gg/aa/yy' Formatinda Guncel (Bugun veya Ileri Bir Tarih) Bir Tarih Ile Doldurur
    And TY Kullanici Save Butonuna Basar
    Then TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    And TY Kullanici SignOut Olur


  Scenario: TC02 Oda oluşturulurken "Room Number" mutlaka olmalı,
            "Room Type"; TWIN, DELUXE, PREMIUM_DELUXE, SUIT ve DAYCARE olmalı
            Var Olan Bir Oda Numarasi Ile Yeni Bir Oda Olusturulamamali
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar
    Then TY Kullanici Room Type TextBox'ina Tiklar
    And TY Kullanici Room Number TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular
    And TY Kullanici Room Number TextBox'ini Zaten Var Olan Bir Oda Numarasi Ile Doldurur
    And TY Kullanici Room Type Alanin default Olarak TWIN Secili Oldugunu Dogrular
    And TY Kullanici Room Type Alanindaki Seceneklerin TWIN, DELUXE, PREMIUM_DELUXE, SUIT ve DAYCARE Oldugunu Dogrular
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    And TY Kullanici Save Butonuna Basar
    Then TY Kullanici Gelen PopUp Mesajinin Kirmizi Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'Room information is not consistent. Room number must be unique'  Oldugunu Dogrular
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    And TY Kullanici SignOut Olur


  Scenario: TC03 Oda icin "Status" ayarlanabilir olmali.
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Status Checkbox'inin Isaretler
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular

    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    And TY Kullanici SignOut Olur


  Scenario: TC04 Fiyat eklenebilir olmalİ ve boS birakilamamali.
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Price TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular
    And TY Kullanici Price TextBox'ini Invalid Bir 'Price' Ile Doldurur ve Price TextBox'inin Altinda This field should be at least 0. Yazisinin Gorundugunu Dogrular
    Then TY Kullanici Price TextBox'ini Temizler
    And TY Kullanici Price TextBox'ini Valid Bir Ifade Ile Doldurur ve Bir Hata Mesaji Almadigini Dogrulamak Icin Ekran Resmi Alir
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    And TY Kullanici SignOut Olur


  Scenario: TC05 "Description" istege bagli olarak doldurulmali.
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    Then TY Kullanici Description TextBox'ina Tiklar
    Then TY Kullanici Created Date TextBox'ina Tiklar
    And TY Kullanici Description TextBox'i Bos Birakildiginda Bir Hata Mesaji Alinmadigini Dogrulamak Icin Ekran Resmi Alir
    And TY Kullanici Description TextBox'ina Tiklar
    Then TY Kullanici Description TextBox'ina 255'den Daha Cok Sayida Karakter Iceren Bir Metin Girer
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Kirmizi Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'Room information is not consistent. Room number must be unique'  Oldugunu Dogrular
    Then TY Kullanici Description TextBox'ina Tiklar
    Then TY Kullanici Description TextBox'ini Temizler Ve Bos Birakir
    And TY Kullanici Created Date TextBox'ina Tiklar
    And TY Kullanici Description TextBox'i Bos Birakildiginda Bir Hata Mesaji Alinmadigini Dogrulamak Icin Ekran Resmi Alir
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    Then TY Kullanici Description TextBox'ina Tiklar Ve 255'den Daha Az Sayida Karakter Iceren Bir Metin Girer
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    And TY Kullanici SignOut Olur


  Scenario: US06 "Created Date" Gun/Ay/Yil seklinde olmali ve gecmis tarih secilememeli.
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    And TY Kullanici Created Date Alaninda Default Olarak Yazan Tarihin Sistem Tarihi Ile Ayni Oldugunu Dogrular
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    Given TY Kullanici Create a New Room Butonuna Tiklar
    Then TY Kullanici Room Number TextBox'ina Tiklar Ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur
    Then TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur
    And TY Kullanici Create Date Alanini 'aa/gg/yy' Formatinda Guncel (Bugun veya Ileri Bir Tarih) Bir Tarih Ile Doldurur
    Then Textbox'ta Yazan Ile Girilen Degerin Ayni Olmadigini Dogrular
    Then TY Kullanici Create Date Alanini 'gg/aa/yy' Formatinda Gecmis Bir Tarih Ile Doldurur
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Kirmizi Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'Bad request.'  Oldugunu Dogrular
    And TY Kullanici Create Date Alanini 'gg/aa/yy' Formatinda Guncel (Bugun veya Ileri Bir Tarih) Bir Tarih Ile Doldurur
    Then TY Kullanici Save Butonuna Basar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Room is created with identifier'  Icerdigini Dogrular
    And TY Kullanici SignOut Olur


  Scenario: US07 Admin ayni tur odalari gorebilir.
    Then TY Kullanici Room Type Sutununda Farkli Turdeki Odalarin Gorundugunu Dogrular ve Ekran Resmi Alir
    Then TY Kullanici Rooms Table'in Header'inda Yer Alan Room Type'a Tiklar
    And TY Kullanici Room Type Sutununda TWIN Tipindeki Odalarin Gorundugunu Dogrular Ve Ekran Resmi Alir
    Then TY Kullanici Rooms Table'in Header'inda Yer Alan Room Type'a Tiklar
    And TY Kullanici Room Type Sutununda DAYCARE Tipindeki Odalarin Gorundugunu Dogrular Ve Ekran Resmi Alir
    And TY Kullanici MANUEL: Kullanici SUITE Tipindeki Odalari Goruntuleyebilmek Icin SearchBox'a SUITE Yazarak Arama Yapar
    And TY Kullanici SignOut Olur


  Scenario: US08 Admin mevcut odalari duzenleyebilir ve guncelleyebilir.
        Given TY Kullanici Yeni Oda Olusturur
        Then TY Kullanici Room Table Header'da ID Alanina Tiklayarak Odalari En Son Olusturulandan Baslayarak Siralar
        Given TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin View Butonuna Basar
        Then TY Kullanici Acilan Room Sayfasinda Edit Butonuna Tiklar
        And TY Kullanici Create or edit a Room Sayfasinin Acildigini Dogrular
        Then TY Kullanici Room Number TextBox'ina Tiklar, Temizler Ve Daha Once Kullanilmamis Yeni Bir Room Number Girer
        And TY Kullanici Room Type Secer
        And TY Kullanici Status'e Tiklar (Secili Ise Kaldirmis, Secili Degilse Secmis Olur)
        Then TY Kullanici Price TextBox'ina Tiklar, Temizler Ve Yeni Bir Price Degeri Girer
        Then TY Kullanici Description TextBox'ina Tiklar, Temizler Ve Yeni Bir Description Girer
        And TY Kullanici Save Butonuna Basar
        And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
        And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A Room is updated with identifier'  Icerdigini Dogrular
        And TY Kullanici Room Table Header'da ID Alanina Tiklayarak Odalari En Son Olusturulandan Baslayarak Siralar
        Given TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin Edit Butonuna Basar
        And TY Kullanici Create or edit a Room Sayfasinin Acildigini Dogrular
        Then TY Kullanici Room Number TextBox'ina Tiklar, Temizler Ve Daha Once Kullanilmamis Yeni Bir Room Number Girer
        And TY Kullanici Room Type Secer
        And TY Kullanici Status'e Tiklar (Secili Ise Kaldirmis, Secili Degilse Secmis Olur)
        Then TY Kullanici Price TextBox'ina Tiklar, Temizler Ve Yeni Bir Price Degeri Girer
        Then TY Kullanici Description TextBox'ina Tiklar, Temizler Ve Yeni Bir Description Girer
        Then TY Kullanici Save Butonuna Basar
        And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
        And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A Room is updated with identifier'  Icerdigini Dogrular
    And TY Kullanici SignOut Olur


  Scenario: TC09 Odalar Admin tarafindan silinebilir.
    Given TY Kullanici Yeni Oda Olusturur
    And TY Kullanici Room Table Header'da ID Alanina Tiklayarak Odalari En Son Olusturulandan Baslayarak Siralar
    Then TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin Delete Butonuna Basar
    Then TY Kullanici Acilan PopUp'da Delete Butonuna Tiklar
    And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
    And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A Room is deleted with identifier '  Icerdigini Dogrular
    And TY Kullanici SignOut Olur

