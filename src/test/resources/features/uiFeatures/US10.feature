
@DEMO
Feature:US010-Doktor kullanıcı olarak randevularını görüntüleyebilmelidir.

  Background: Medunna Healt Sayfasına gidilir.
    Given HY "url" adresine gidilir
    Given HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na Tıklanır.

  Scenario:TC01-Kullanıcı Doktor olarak  register işlemi yapabilmelidir.
    Given HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na Tıklanır.
    Given HY Açılan sekmeden Register seçecegi seçilmelidir.
    Given HY Kullanıcı şifre olarak "DoktorSSN" kutusu doldurulmaldır.
    Given HY Kullanıcı isim olarak "DoktorFirstName" kutusu doldurulmalıdır.
    Given HY Kullanıcı soyisim olarak "DoktorLastName" kutusu doldurulmaldır.
    Given HY Kullanıcı username olarak  "DoktorUserName" kutusu doldurulmalıdır.
    Given HY Kullanıcı email olarak  "Email" kutusu doldurulmalıdır.
    Given HY  "NewPassword" istenildigi gibi doldurulmalıdır.
    Given HY  "NewPassword" Confirmation butonuna belirlenen password girilmelidir.
    Given HY  Register butonuna tıklanmalıdır.
    Given HY  Başarılı kayıt yapıldı yazısı görülmelidir.
    Given HY Sayfa kapatılır.


  Scenario:TC02-Kullanıcı, randevu listesini ve zaman dilimlerini "My Appointments" sekmesinden görebilmelidir.
    Then  HY Açılan sekmeden Sing in seçecegi seçilmelidir.
    Then  HY Kullanıcı kayıtlı olduğu "DoktorUserName" i girmelidir.
    Then  HY Kullanıcı kayıtlı olduğu "DoktorPassword" u girmelidir.
    Given HY kullanıcı Sing in butonuna basar.
    Then  HY Sayfanın üstündeki menüden MY PAGES(PATİENT) seçeneğine tıklar.
    Given HY Açılan dropdowndan MY Appointments seçeneği seçilmelidir.
    Then  HY Kontrol etmek istediği zaman aralığını girer.
    Then  HY Oluşturulan randevular görünür olduğu test edilir.
    Then  HY Sayfa kapatılır.

    Scenario:TC03-Kullanıcı "patient id, start date, end date, status" bilgilerini görebilmeli
      Then  HY Açılan sekmeden Sing in seçecegi seçilmelidir.
      Then  HY Kullanıcı kayıtlı olduğu "DoktorUserName" i girmelidir.
      Then  HY Kullanıcı kayıtlı olduğu "DoktorPassword" u girmelidir.
      Given HY kullanıcı Sing in butonuna basar.
      Then  HY Sayfanın üstündeki menüden MY PAGES(PATİENT) seçeneğine tıklar.
      Given HY Açılan dropdowndan MY Appointments seçeneği seçilmelidir.
      Then  HY Kontrol etmek istediği zaman aralığını girer.
      Given HY Secilen zaman dilimindeki randevularda Patient ID görünür olmalıdır.
      Then  HY Secilen zaman dilimindeki randevularda Start Date Time görünür olmaldır.
      Then  HY Secilen zaman dilimindeki randevularda End Date Time  görünür olmalıdır.
      Then  HY Secilen zaman dilimindeki randevularda Status durumu görünür olmalıdır.
      Then HY Sayfa kapatılır.
