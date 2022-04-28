Feature: US028 Admin olarak; Country oluşturma / Okuma ve Silme

  Scenario Outline: TC03_Kullanıcı bunları API ile dogrulayabilmelidir.
    Given TG Kullanici "https://www.medunna.com/api/countries/" den "<CountryId>","<CountryName>" bilgilerini girdigi ulkenin olusturuldugunu dogrular
    Then TG Kullanici "https://www.medunna.com/api/c-states/" den "<CountryId>","<CountryName>" ve "<StateId>","<StateName>" bilgilerini girdigi State olusturuldugunu dogrular

    Examples:
    |CountryId   |CountryName |StateId |StateName|
    |80075       |kambocya1   |89256   |KambocyaState|


  Scenario Outline: TC04_Kullanıcı, API kullanarak mevcut ulkeleri guncelleyebilmelidir.
    Given TG Kullanici "https://www.medunna.com/api/countries/" den "<CountryId>","<CountryName>" bilgilerini girdigi ulkenin bilgilerini guncelleyebildigini dogrular
    Then TG Kullanici "https://www.medunna.com/api/c-states/" den "<CountryId>","<CountryName>" ve "<StateId>","<StateName>" bilgilerini girdigi State guncelleyebildigini dogrular

    Examples:
    |CountryId   |CountryName |StateId |StateName|
    |80075       |kambocya1   |89256   |KambocyaState|