@DEMO
Feature:Kullanici giriş yaptiginda Password sekmesi duzenlenebilir olmalidir.
  Admin/Staff/Patient/Doctor

  Background:
    When URL adresine gidilir.

  Scenario:TC01 Kullanici  Admin olarak giris yaptiginda Password sekmesinde "New password confirmation" onaylanabilmelidir.
    Then "Admin" olarak giris yapilir.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then New password confirmation onaylanabilmelidir.
    And "Admin" olarak cikis yapilir


  Scenario:TC01 Kullanici  Admin olarak giris yaptiginda Password sekmesinde seviyenin degistigini gormelidir
    Then "Admin" olarak giris yapilir.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then Daha guclu sifre icin en az 1 kucuk harf olmali,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 buyuk harf icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 rakam icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 ozel karakter icermeli,toplam  en az 7 karekter olmali ve"Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Guclu bir parola icin sifre en az 7 karakterden olusmalidir.
    And "Admin" olarak cikis yapilir

   Scenario:TC01 Kullanici  Admin olarak giris yaptıgında Password sekmesinde Eski sifre kullanilmamalidir
     Then "Admin" olarak giris yapilir.
     Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
     And Eski sifre kullanilmamalidir.


  Scenario:TC02 Kullanıcı  Staff olarak giriş yaptığında Password sekmesinde "New password confirmation" onaylanabilmelidir.
    And "Admin" olarak cikis yapilir
    Then Staff olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then New password confirmation onaylanabilmelidir.
    And "Staff" olarak cikis yapilir

  Scenario:TC02 Kullanıcı  Staff olarak giriş yaptığında Password sekmesinde seviyenin değiştiğini görmelidir
    Then Staff olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then Daha guclu sifre icin en az 1 kucuk harf olmali,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 buyuk harf icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 rakam icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 ozel karakter icermeli,toplam  en az 7 karekter olmali ve"Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Guclu bir parola icin sifre en az 7 karakterden olusmalidir.
    And "Staff" olarak cikis yapilir

  Scenario:TC02 Kullanıcı  Staff olarak giriş yaptığında Password sekmesinde Eski şifre kullanılmamalıdır
    Then Staff olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    And Eski sifre kullanilmamalidir.


  Scenario:TC03 Kullanıcı  Patient olarak giriş yaptığında Password sekmesinde "New password confirmation" onaylanabilmelidir.
    And "Staff" olarak cikis yapilir
    Then Patient olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then New password confirmation onaylanabilmelidir.
    And "Patient" olarak cikis yapilir

  Scenario:TC03 Kullanıcı  Patient olarak giriş yaptığında Password sekmesinde seviyenin değiştiğini görmelidir
    Then Patient olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then Daha guclu sifre icin en az 1 kucuk harf olmali,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 buyuk harf icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 rakam icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 ozel karakter icermeli,toplam  en az 7 karekter olmali ve"Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Guclu bir parola icin sifre en az 7 karakterden olusmalidir.
    And "Patient" olarak cikis yapilir

  Scenario:TC03 Kullanıcı  Patient olarak giriş yaptığında Password sekmesinde Eski şifre kullanılmamalıdır
    Then Patient olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    And Eski sifre kullanilmamalidir.


  Scenario:TC04 Kullanıcı  Doctor olarak giriş yaptığında Password sekmesinde "New password confirmation" onaylanabilmelidir.
    And "Patient" olarak cikis yapilir
    Then Doctor olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then New password confirmation onaylanabilmelidir.
    And "Doctor" olarak cikis yapilir

  Scenario:TC04 Kullanıcı  Doctor olarak giriş yaptığında Password sekmesinde seviyenin değiştiğini görmelidir
    Then Doctor olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    Then Daha guclu sifre icin en az 1 kucuk harf olmali,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 buyuk harf icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 rakam icermeli,toplam  en az 7 karekter olmali ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Sifre en az 1 ozel karakter icermeli,toplam  en az 7 karekter olmali ve"Password strength:" seviyesinin degistigi gorulebilmelidir.
    Then Guclu bir parola icin sifre en az 7 karakterden olusmalidir.
    And "Doctor" olarak cikis yapilir

  Scenario:TC04 Kullanıcı  Doctor olarak giriş yaptığında Password sekmesinde Eski şifre kullanılmamalıdır
    Then Doctor olarak giriş yapılır.
    Then Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.
    And Eski sifre kullanilmamalidir.

  Scenario:TC04 Doktor olarak cikis yapilir
    And "Doctor" olarak cikis yapilir



