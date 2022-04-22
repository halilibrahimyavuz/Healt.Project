Feature: Messages by Admin Validate with API and DB

  Background:
    Given TY Kullanici URL Adresine Gider ve "Admin" Olarak Sign In Olur
    Then TY Kullanici Sign-In Isleminin Basarili Olarak Gerceklestigini Dogrular
    Then TY Kullanici Navigation Bar'dan "Items&Titles" a Tiklar
    Then TY Kullanici Acilan Dropdown Menuden "Messages" Secenegine Tiklar
    And TY Kullanici "Messages" Sayfasinin Acildigini Dogrular


  Scenario: TC01 Admin, mesaj portalina gidebilir ve tum mesajlari, yazarlarini ve e-postalarini goruntuleyebilir.
    Then TY Kullanici Messages Tablosunda "ID", "Name", "Email", "Subject", "Message" Basliklarinin Oldugunu Dogrular
    Then TY Kullanici Yeni Mesaj Olusturur
    And TY Kullanici  Olusturulan Bu Mesajin ID Numarasini Kaydeder
    Then TY Kullanici Message Table Header'da ID Alanina Tiklayarak Mesajlari En Son Olusturulandan Baslayarak Siralar
    And TY Kullanici Message Table'da Ilk Satirdaki Mesajin ID Sutununda Yer Alan Degerin, Mesaj Olusturuken Girdigi ID Oldugunu Dogrular
    And TY Kullanici Message Table'da Ilk Satirdaki Mesajin Name Sutununda Yer Alan Degerin, Mesaj Olusturuken Girdigi Name Oldugunu Dogrular
    And TY Kullanici Message Table'da Ilk Satirdaki Mesajin Email Sutununda Yer Alan Degerin, Mesaj Olusturuken Girdigi Email Oldugunu Dogrular
    And TY Kullanici Message Table'da Ilk Satirdaki Mesajin Subject Sutununda Yer Alan Degerin, Mesaj Olusturuken Girdigi Subject Oldugunu Dogrular
    And TY Kullanici Message Table'da Ilk Satirdaki Mesajin Message Sutununda Yer Alan Degerin, Mesaj Olusturuken Girdigi Message Oldugunu Dogrular
    Then TY Kullanici Message Table Header'da ID Alanina Tiklayarak Mesajlari Ilk Olusturulandan Baslayarak Siralar
    And TY Kullanici Sayfayi, Olusturdugu Yeni Mesajin ID Numarasini Gorene Kadar Kaydirir ve Kaydirirken Olusturulmus Tum Mesajlari Goruntuler
    And TY Kullanici SignOut Olur

    Scenario: TC02 Admin, mesajlari olusturabilir, guncelleyebilir, silebilir.
      Given TY Kullanici Create a New Message Butonuna Tiklar
      Then TY Kullanici Create or edit a Message Sayfasinin Açildigini Dogrular
      Then TY Kullanici Name TextBox'ina Tiklar
      Then TY Kullanici Email TextBox'ina Tiklar
      Then TY Kullanici Subject TextBox'ina Tiklar
      And TY Kullanici Name TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular
      And TY Kullanici Email TextBox'inin Altinda 'Your email is required.' Yazisinin Gorundugunu Dogrular
      And TY Kullanici Subject TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular
      Then TY Kullanici Name TextBox'ina Tiklar ve Isim Girer
      Then TY Kullanici Email TextBox'ina Tiklar @mail.com Icermeyen Bir Mail Girer
      Then TY Kullanici Email TextBox'inin Altinda 'This field is invalid' Yazisinin Gorundugunu Dogrular
      Then TY Kullanici Subject TextBox'ina Tiklar ve Konuyu Girer
      Then TY Kullanici Message TextBox'ina Tiklar ve Mesaji Girer
      And TY Kullanici Save Butonuna Tiklar
      And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir
      And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A new Message is created with identifier'  Icerdigini Dogrular
      And TY Kullanici Room Table Header'da ID Alanina Tiklayarak Mesajlari En Son Olusturulandan Baslayarak Siralar

      Given TY Kullanici Room Table'da Ilk Satirda Yer Alan Mesajin View Butonuna Basar
      And TY Kullanici Acilan Message Sayfasinda Edit Butonuna Tiklar
      And TY Kullanici Create or edit a Message Sayfasinin Acildigini Dogrular
      Then TY Kullanici Name TextBox'ina Tiklar, Temizler Ve Yeni Name'i Girer
      Then TY Kullanici Email TextBox'ina Tiklar, Temizler Ve Yeni Email'i Girer
      Then TY Kullanici Subject TextBox'ina Tiklar, Temizler Ve Yeni Suject'i Girer
      Then TY Kullanici Message TextBox'ina Tiklar, Temizler Ve Yeni Message'i Girer
      Then TY Kullanici Save Butonuna Basar
      And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
      And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A Message is updated with identifier'  Icerdigini Dogrular
      And TY Kullanici Room Table Header'da ID Alanina Tiklayarak Mesajlari En Son Olusturulandan Baslayarak Siralar

      Given TY Kullanici Room Table'da Ilk Satirda Yer Alan Mesajin Edit Butonuna Basar
      And TY Kullanici Create or edit a Message Sayfasinin Acildigini Dogrular
      Then TY Kullanici Name TextBox'ina Tiklar, Temizler Ve Yeni Name'i Girer
      Then TY Kullanici Email TextBox'ina Tiklar, Temizler Ve Yeni Email'i Girer
      Then TY Kullanici Subject TextBox'ina Tiklar, Temizler Ve Yeni Suject'i Girer
      Then TY Kullanici Message TextBox'ina Tiklar, Temizler Ve Yeni Message'i Girer
      And TY Kullanici Save Butonuna Basar
      And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
      And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A Message is updated with identifier'  Icerdigini Dogrular
      And TY Kullanici Room Table Header'da ID Alanina Tiklayarak Mesajlari En Son Olusturulandan Baslayarak Siralar

      Given TY Kullanici Room Table'da Ilk Satirda Yer Alan Mesajin Delete Butonuna Basar
      Then TY Kullanici Acilan PopUp'da Delete Butonuna Tiklar
      And TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir
      And TY Kullanici PopUp Uzerinde Yer Alan Mesajin 'A Message is deleted with identifier'  Icerdigini Dogrular
      And TY Kullanici SignOut Olur

