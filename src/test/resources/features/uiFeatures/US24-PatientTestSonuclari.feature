@TC-Fatura
Feature:US24 TEST SONUCLARİ

@tc01
 Scenario:TC_001 TEST SONUCLARİNİ GORME
   Given Patient URL 'e  gider
   And  Ptaient insan ikonuna tiklar
   And  Patient sign in sekmesine tiklar
   Then Patient username girer
   Then Patient password girer.
   And  Patient  sign in butonuna tiklar
   Then Patient giris yapildigini dogrular
   And  Patient my pages'e tiklar
   And  Patient My Appointments tiklar
   Then Patient randevu listesini gorur
   Then Patient from kismina tarih girer
   Then Patient to kismina tarih girer
   And  Patient Show Tests 'e tiklar
   And  Patient view  Results'a tiklar
   Then Patient Test sonuclarinda id,name,test,default max ve min value,date and description bolumlerini gorur
   And Sayfayi kapatir

  Scenario: TC_002 Hasta faturasini gorebilme
    Given  Patient URL 'e  gider
    And  Ptaient insan ikonuna tiklar
    And  Patient sign in sekmesine tiklar
    Then Patient username girer
    Then Patient password girer.
    And  Patient  sign in butonuna tiklar
    Then Patient giris yapildigini dogrular
    And  Patient my pages'e tiklar
    And  Patient My Appointments tiklar
    Then Patient randevu listesini gorur
    Then Patient from kismina tarih girer
    Then Patient to kismina tarih girer
    And   Patient Show  Invoice 'e tiklar
    Then  Patient faturayi gordugunu dogrular
    And Sayfayi kapatir

