Feature:My Appointments Physician (Doctor) tarafından düzenlenebilmelidir.

  Scenario:TC01-Anasayfadan bir randevu oluşturulabilmelidir.

    Given HY "url" adresine gidilir
    Then HY Sayfanın en altındakı Make an Appointment bölümüne gidilir.
    Then HY İsim bölümüne "FirstName" girilir.
    Then HY Soyisim bölümüne "LastName" girilir.
    Then HY Şifre yerine "SSN" girilir.
    Then HY Uygun bir "Email" girilir.
    Then HY Kullanılan "Phone" girilir.
    Then HY Appointment Date time girilir.
    Then HY Send an Appointment Date time butonuna tiklanir.
    Given HY Anasayfadan Başarılı kayıt yapıldı yazısı görülmelidir.
    Given HY Sayfa kapatılır.

  Scenario:TC02-Bir randevu güncellendiğinde; kullanıcı (doktor), hastanın bilgilerini ( "id, start and end date, Status, physician and patient")  bilgilerini görmelidir.
    Given HY "url" adresine gidilir
    Given HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na Tıklanır.
    Then  HY Açılan sekmeden Sing in seçecegi seçilmelidir.
    Then  HY Kullanıcı kayıtlı olduğu "DoktorUserName" i girmelidir.
    Then  HY Kullanıcı kayıtlı olduğu "DoktorPassword" u girmelidir.
    Given HY kullanıcı Sing in butonuna basar.
    Then  HY Sayfanın üstündeki menüden MY PAGES(PATİENT) seçeneğine tıklar.
    Given HY Açılan dropdowndan MY Appointments seçeneği seçilmelidir.
    Then  HY Kontrol etmek istediği zaman aralığını girer.
    Then HY Görüntülenen randevu bilgilerinin en solundaki Edit Butonuna tıklamalıdır.
    Then HY Create or Edit Appointment sayfası görülmelidir.
    When HY ID bilgisi görünür olmaldır.
    When HY Start Date Time bilgisi görünür olmalıdır.
    Then HY End Date Time bilgileri görünür olmalıdır.
    Then HY Status bilgisi görünür olmalıdır.
    Then HY Physician bilgileri görünür olmalıdır.
    When HY Sayfa kapatılır.

  Scenario:TC03-Doktor gerekli alanlara "Anamnesis, Treatment ve Diagnosis" yazabilmelidir.
    Given HY "url" adresine gidilir
    Given HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na Tıklanır.
    Then  HY Açılan sekmeden Sing in seçecegi seçilmelidir.
    Then  HY Kullanıcı kayıtlı olduğu "DoktorUserName" i girmelidir.
    Then  HY Kullanıcı kayıtlı olduğu "DoktorPassword" u girmelidir.
    Given HY kullanıcı Sing in butonuna basar.
    Then  HY Sayfanın üstündeki menüden MY PAGES(PATİENT) seçeneğine tıklar.
    Given HY Açılan dropdowndan MY Appointments seçeneği seçilmelidir.
    Then  HY Kontrol etmek istediği zaman aralığını girer.
    Then HY Görüntülenen randevu bilgilerinin en solundaki Edit Butonuna tıklamalıdır.
    Then HY Create or Edit Appointment sayfası görülmelidir.
    Given HY Anamnesis bölümü doldurulabilmelidir.
    Given HY Treatment bölümü doldurulabilmelidir.
    Given HY Diagnosis bölümü doldurulabilmelidir.
    Given HY Sayfa kapatılır.

    Scenario:TC04-Doktor tarafından doldurulacak "prescription ve description" bölümlerini zorunlu olmamalıdır.
      Given HY "url" adresine gidilir
      Given HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na Tıklanır.
      Then  HY Açılan sekmeden Sing in seçecegi seçilmelidir.
      Then  HY Kullanıcı kayıtlı olduğu "DoktorUserName" i girmelidir.
      Then  HY Kullanıcı kayıtlı olduğu "DoktorPassword" u girmelidir.
      Given HY kullanıcı Sing in butonuna basar.
      Then  HY Sayfanın üstündeki menüden MY PAGES(PATİENT) seçeneğine tıklar.
      Given HY Açılan dropdowndan MY Appointments seçeneği seçilmelidir.
      Then  HY Kontrol etmek istediği zaman aralığını girer.
      Then HY Görüntülenen randevu bilgilerinin en solundaki Edit Butonuna tıklamalıdır.
      Then HY Create or Edit Appointment sayfası görülmelidir.
      Given HY Prescription bölümü doldurulması zorunlu olmamalıdır.
      Given HY Description bölümü doldurulması zorunlu olmamalıdır.
      Given HY Sayfa kapatılır.


    Scenario:TC05-"Status" doktor tarafından "PENDING, COMPLETED veya CANCELLED" olarak seçilebilmeli
      Given HY "url" adresine gidilir
      Given HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na tiklanir.
      Then  HY Açılan sekmeden Sing in seçecegi seçilmelidir.
      Then  HY Kullanıcı kayıtlı olduğu "DoktorUserName" i girmelidir.
      Then  HY Kullanıcı kayıtlı olduğu "DoktorPassword" u girmelidir.
      Given HY kullanıcı Sing in butonuna basar.
      Then  HY Sayfanın üstündeki menüden MY PAGES(PATİENT) seçeneğine tıklar.
      Given HY Açılan dropdowndan MY Appointments seçeneği seçilmelidir.
      Then  HY Kontrol etmek istediği zaman aralığını girer.
      Then HY Görüntülenen randevu bilgilerinin en solundaki Edit Butonuna tıklamalıdır.
      Then HY Create or Edit Appointment sayfası görülmelidir.
      When HY Status bölümü PENDING olarak seçilebilmelidir.
      When HY Status bölümü COMPLETED olarak seçilebilmelidir.
      When HY Status bölümü CANCELLED olarak seçilebilmelidir.
      When HY Save butonu aktif omalıdır.
      When HY Sayfa kapatılır.


