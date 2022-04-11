@Dynamic
Feature: Settings

  @1
    @Dynamic1
  Scenario Outline: Setting secenegi assertion
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    Then FK01 Kullanıcı signin butonundan settings seçeneğini assert etmeli
    Then Kullanıcı accountMenu tuşuna basar
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır

    Examples:
      | username     | password  |
      | patientfurkan| Medunna.82|

  @2
    @Dynamic1
  Scenario Outline: FirstName Assertion
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK02 Kullanıcı FirstName kutucuğunu assert etmeli
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |
      | patientfurkan| Medunna.82|


  @3
    @Dynamic1
  Scenario Outline: Lastname Assertion
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK03 Kullanıcı LastName kutucuğunu assert etmeli
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |
      | patientfurkan| Medunna.82|

  @4
    @Dynamic1
  Scenario Outline: Email Assertion
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK04 Kullanıcı Email kutucuğunu assert etmeli
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |
      | patientfurkan| Medunna.82|

  @5
    @Dynamic1
  Scenario Outline: Email combinasyonu_1
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK05 Kullanıcı Email kutusu varsa "<dotcom>" olmadan güncelleme yapabiliyormu
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |dotcom               |
      | patientfurkan| Medunna.82|patientfurkan@medunna|


  @6
    @Dynamic1
  Scenario Outline: Email combinasyonu_2
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK06 Kullanıcı Email kutusu varsa "<atdotcom>" şeklinde güncelleme yapabiliyormu
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |atdotcom   |
      | patientfurkan| Medunna.82|furkan@.com|

  @7
    @Dynamic1
  Scenario Outline: Email combinasyonu_3
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK07 Kullanıcı Email kutusu varsa "<bos>" geçerek güncelleme yapabiliyormu
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |bos |
      | patientfurkan| Medunna.82|    |

  @8
    @Dynamic1
  Scenario Outline: Email combinasyonu_4
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK08 Kullanıcı Email kutusu varsa @ işaretinden önce "<attenOnceBos>" karakterle güncelleme yapabiliyormu
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |attenOnceBos |
      | patientfurkan| Medunna.82|@medunna.com |

  @9
    @Dynamic1
  Scenario Outline: Email combinasyonu_5
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK19 Kullanıcı Email kutusu varsa @ işaretinden önce "<attenOnceBir>" karakterle güncelleme yapabiliyormu

    Examples:
      | username     | password  |attenOnceBir|
      | patientfurkan| Medunna.82|a@med.com   |

  Scenario:
    Then FK Kullanıcı signOut olur
    Then Sayfa kapanır

  @10
    @Dynamic1
  Scenario Outline: Email combinasyonu_6
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK09 Kullanıcı Email kutusu varsa email yazılırken "<bosluk>" varsa güncelleme yapabiliyormu
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |bosluk       |
      | patientfurkan| Medunna.82|pa fu@med.com|

  @11
    @Dynamic1
  Scenario Outline: Email combinasyonu_7
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK10 Kullanıcı Email kutusu varsa daha önce "<kullanilmis_email>" yazılabilirmi
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |kullanilmis_email   |
      | patientfurkan| Medunna.82|drfurkan@medunna.com|

  @12
    @Dynamic1
  Scenario Outline: Email combinasyonu_8
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    And FK11 Kullanıcı Email kutusu varsa "<buyuk_harf>" yazılabilirmi
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |buyuk_harf  |
      | patientfurkan| Medunna.82|FURN@med.com|

  @13
    @Dynamic1
  Scenario Outline: FirstName combinasyonu_1
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK12 Kullanıcı FirstName kutusu varsa "<bos>" geçerek güncelleme yapabiliyormu
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |bos|
      | patientfurkan| Medunna.82|   |

  @14
    @Dynamic2
  Scenario Outline: FirstName combinasyonu_2
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK13 Kullanıcı FirstName kutusuna "<rakam>" yazarak güncelleme yapabiliyormu


    Examples:
      | username     | password  |rakam|
      | patientfurkan| Medunna.82|1452 |

  Scenario:
    Then FK Kullanıcı signOut olur
    Then Sayfa kapanır

  @15
    @Dynamic2
  Scenario Outline: FirstName combinasyonu_3
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK14 Kullanıcı FirstName kutusuna "<tek_harf>" yazarak güncelleme yapabiliyormu

    Examples:
      | username     | password  |tek_harf|
      | patientfurkan| Medunna.82|s       |


  Scenario:
    Then FK Kullanıcı signOut olur
    Then Sayfa kapanır
  @16
    @Dynamic2
  Scenario Outline: LastName combinasyonu_1
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK15 Kullanıcı LastName kutusu varsa "<bos>" geçerek güncelleme yapabiliyormu
    Then FK Kullanıcı signOut olur
    And Sayfa kapanır
    Examples:
      | username     | password  |bos|
      | patientfurkan| Medunna.82|   |

  @17
    @Dynamic1
  Scenario Outline: LastName combinasyonu_2
    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK16 Kullanıcı LastName kutusuna "<rakam>" yazarak güncelleme yapabiliyormu

    Examples:
      | username     | password  |rakam|
      | patientfurkan| Medunna.82|785  |

  Scenario:
    Then FK Kullanıcı signOut olur
    Then Sayfa kapanır
  @18
    @Dynamic5
  Scenario Outline: LastName combinasyonu_3

    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK17 Kullanıcı LastName kutusuna "<ozel_karakter>" yazarak güncelleme yapabiliyormu

    Examples:
      | username     | password  |ozel_karakter|
      | patientfurkan| Medunna.82|;            |
  @Dynamic5
  Scenario:
    Then FK Kullanıcı signOut olur
    Then Sayfa kapanır
  @19
    @Dynamic5
  Scenario Outline: LastName combinasyonu_4

    Given FK Kullanıcı ana sayfaya gider
    And FK Kullanıcı sign in butonuna basar
    And FK Kullanıcı username kutusuna "<username>" bilgilerini girer
    And FK Kullanıcı password kutusuna "<password>" bilgilerini girer
    And FK Kullanıcı settings seçeneği varsa tıklamalı
    Then FK18 Kullanıcı LastName kutusuna "<tek_harf>" yazarak güncelleme yapabiliyormu

    Examples:
      | username     | password  |tek_harf|
      | patientfurkan| Medunna.82|s       |


  @Dynamic5
  Scenario:
    Then FK Kullanıcı signOut olur
    Then Sayfa kapanır