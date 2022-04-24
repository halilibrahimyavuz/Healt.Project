Feature:US020 Admin; "User management" menusunden, kullanici Active eder ve gerekli rolleri olusturur.

  Scenario: TC01-Admin, kayıtlı kişilerin "firstname, lastname, email... Gibi bilgilerini görebilmelidir.
    * HY "url" adresine gidilir
    * HY Sayfanin en üst sag kismindaki Profile Ikonu`na tiklanir.
    * HY Acilan sekmeden"Sing in" secenegi secilmelidir.
    * HY Kullanici kayitli oldugu "AdminUSerName" i girmelidir.
    * HY Kullanıcı kayitli oldugu "AdminPassword" ü girmelidir.
    * HY Sing in butonuna basmalidir.
    * HY Üstteki menulerden "Adminisration" secenegine tiklanmalidir.
    * HY Acilan sekmeden "User management" secenegi secilmelidir.
    * HY Gormek istedigi kayitli kisinin uzerine gelip en sagda bulunan "View" butonuna tiklanmalidir.
    * HY First name bilgisi gorunur olmalidir.
    * HY Last name bilgisi gorunur olmalidir.
    * HY Email bilgisi gorunur olmalidir.
    * HY Profiles durumu gorunur olmalidir.
    * HY Admin Sing out butonuna basarak cikis yapmalidir.

    Scenario: TC02-Admin kullanıcılıar aktive edebilir ve rollerini "ADMIN, USER
    PATIENT, STAFF ve PHYSICIAN" olarak atayabilir.
      * HY URL adresine gidilir
      * HY Sayfanin en üst sag kismindaki Profile Ikonu`na tiklanir.
      * HY Acilan sekmeden"Sing in" secenegi secilmelidir.
      * HY Kullanici kayitli oldugu Username i girmelidir.
      * HY Kullanıcı kayitli oldugu Password ü girmelidir.
      * HY Sing in butonuna basmalidir.
      * HY Üstteki menulerden "Adminisration" secenegine tiklanmalidir.
      * HY Acilan sekmeden "User management" secenegi secilmelidir.
      * HY Admin rol atamasi yapmak istedigi kisinin uzerine gelip en sagda bulunan "Edit" butonuna tiklamalidir.
      * HY "Create or edit a user" sayfasinin acildigini dogrulamaldiir.
      * HY Acilan sayfada "Pofiles" kismina gelip dropdowndan rol atamasi yapabilmelidir.
      * HY Save butonuna basmalidir.
      * HY "A user is updated with identifier" yazisinin ciktigini dogrulamalidir.
      * HY Admin Sing out butonuna basarak cikis yapmalidir.

      Scenario: TC03- Adm'n kullaniclari silebilmelidir.
        * HY URL adresine gidilir
        * HY Sayfanin en üst sag kismindaki Profile Ikonu`na tiklanir.
        * HY Acilan sekmeden"Sing in" secenegi secilmelidir.
        * HY Kullanici kayitli oldugu Username i girmelidir.
        * HY Kullanıcı kayitli oldugu Password ü girmelidir.
        * HY Sing in butonuna basmalidir.
        * HY Üstteki menulerden "Adminisration" secenegine tiklanmalidir.
        * HY Acilan sekmeden "User management" secenegi secilmelidir.
        * HY Admin silmek istedigi kullanicinin ustune en sagda bulunan "Delete" butonuna tiklamalidir.
        * HY Yukarıda cikan popup uzerindeki "Delete" butonuna tiklanmalidir.
        * HY "A user is deleted with identifier" yazisinin ciktigini dogrulamalidir.
        * HY Admin Sing out butonuna basarak cikis yapmalidir.
