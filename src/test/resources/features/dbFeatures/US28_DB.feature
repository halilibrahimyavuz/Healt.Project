Feature: US028 Admin olarak; Country oluşturma / Okuma ve Silme

  Scenario: TC05_Kullanıcı bunları DB ile dogrulamalıdır
    Given TG Kullanici Medunna Database e baglanir
    And TG Kullanici "country" tablosundan "80075" idli Countryi sorgular ve olustugunu dogrular
    And TG Kullanici "c_state" tablosundan "89256" idli State Cityi sorgular ve olustugunu dogrular
