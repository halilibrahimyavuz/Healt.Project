Feature:US15 Admin tarafından hasta oluşturma ve düzenleme

  Scenario:US15_TC01 Yeni hastalar yalnızca yönetici tarafından olusturulabilmeli

    Given EA Kullanici "medunna" anasayfaya gider
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And EA Kullanici Sign-in butonuna tiklar
    And EA Kullanici Admin Username girer
    And EA Kullanici Admin Password girer
    And EA Kullanici ikinci Sign-in butonuna tiklar
    And EA Admin olarak oturum acildigi dogrulanir
    And EA Kullanici Items&Titles bolumune tiklar
    And EA Kullanici Patient bolumune tiklar
    And EA Kullanici acilan Patient sayfasindan Create or edit a Patient kutusuna tiklar
    And EA Kullanici hasta kaydi olusturabilmek icin gerekli olan First Name,Last Name, Birt Date, Email, Phone, Gender, Blood Group, Adress,Description, User, Country, StateCity bolumlere veri girisi yapar
    And EA Kullanici Save butonun tiklar
    And EA Kullanici Yeni Hasta olusturuldugunu alert mesaji ile dogrular
    And EA Kullanici sayfayi kapatir

  Scenario:US15_TC02 Yönetici "SSN, First Name, Last Name,
  Birth Date, Phone, Gender, Blood Group, Address,
  Description, Created Date, User, Country and state / City"
  gibi hasta bilgilerini gorebilir.

    Given EA Kullanici "medunna" anasayfaya gider
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And EA Kullanici admin olarak oturum acar
    And EA Admin olarak oturum acildigi dogrulanir
    And EA Kullanici Items&Titles bolumune tiklar
    And EA Kullanici Patient bolumune tiklar
    And EA Kullanici Created Date bolumune tiklar
    And EA Kullanici ilk sirada gelen hastanin ID numarasina tiklar
    And EA Kullanici SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group,Address,Description, Created Date, User, Country and stateCity bilgilerinin gorunurlugunu test eder
    And EA Kullanici sayfayi kapatir

  Scenario:US15_TC03 Hasta oluşturulduğunda veya güncellendiginde
  yukarıdaki ogelere data girisi yapilabilmeli.

    Given EA Kullanici "medunna" anasayfaya gider
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And EA Kullanici admin olarak oturum acar
    And EA Kullanici Items&Titles bolumune tiklar
    And EA Kullanici Patient bolumune tiklar
    And EA Kullanici Created Date bolumune tiklar
    And EA Kullanici ilk sirada gelen hastanin ID numarasina tiklar
    And EA Kullanici edit butonuna tiklar
    And EA Kullanici Acilan sayfada  SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and stateCity gibi bilgilerden bazilarinda degisiklik yapar
    And EA Kullanici Save butonuna tiklar
    And EA Kullanici hasta bilgilerinin guncellendigi dogrulanir
    And EA Kullanici sayfayi kapatir

  Scenario:US15_TC04 Hastaya doktoru sadece Admin atayabilir.

    Given EA Kullanici "medunna" anasayfaya gider
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And EA Kullanici admin olarak oturum acar
    And EA Kullanici Items&Titles bolumune tiklar
    And EA Kullanici Appointment bolumune tiklar
    And EA Kullanici Create a new Appointment butonuna tiklar
    And EA Kullanici Start DateTime ve End Date Time bilgileri girer
    And EA Kullanici Status kismi secer
    And EA Kullanici Physician kismindan Doktor bilgisi secer
    And EA Kullanici Patient kismindan Hasta bilgisi secer
    And EA Kullanici islemlerin ardindan Save butonuna tiklar
    And EA Hasta kaydinin doktora atamasinin yapildigi dogrulanir
    And EA Kullanici sayfayi kapatir

  Scenario:US15_TC05 "State", "US state" olmalı ve boş bırakılmamalı

    Given EA Kullanici "medunna" anasayfaya gider
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And EA Kullanici admin olarak oturum acar
    And EA Kullanici Items&Titles bolumune tiklar
    And EA Kullanici StateCity bolumune tiklar ve verileri kaydeder
    And EA StatesCities sayfasinda StateCity bolumunun US oldugu test edilir
    And EA StatesCities sayfasinda StateCity bolumunun bos olmamasi gerektigi test edilir
    And EA Kullanici sayfayi kapatir

  Scenario:US15_TC06 Yönetici herhangi bir hastayı silebilir

    Given EA Kullanici "medunna" anasayfaya gider
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And EA Kullanici admin olarak oturum acar
    And EA Kullanici Items&Titles bolumune tiklar
    And EA Kullanici Patient bolumune tiklar
    And EA Kullanici acilan Patient sayfasindan Create or edit a Patient kutusuna tiklar
    And EA Kullanici hasta kaydi olusturabilmek icin gerekli olan First Name,Last Name, Birt Date, Email, Phone, Gender, Blood Group, Adress,Description, User, Country, StateCity bolumlere veri girisi yapar
    And EA Kullanici Save butonun tiklar
    And EA Kullanici Created Date bolumune tiklar
    And EA Kullanici Ilk sirada gelen hasta ile ayni satirda bulunan Delete butonuna tiklar
    And EA Kullanici Confirm Delete Operation uyari mesajindan tekrar delete butonuna tiklar
    And EA Uyari mesaji ile Hasta kaydinin silindigi test edilir
    And EA Kullanici sayfayi kapatir


