Feature:

 Scenario:
    Given FK url e gider
    And FK Kullanici First Name textbox'a  gecerli bir firstname girer
    And FK Kullanici lastname kismini doldurur
    Then FK Kullanici ssn kismini doldurur
    And FK Kullanici email kismina gecerli bir email girer
    Then FK Kullanici phone kismini doldurur
    Then FK Kullanici Send an appoitment Request kismina tiklar

   And ucsaniye bekle

  Scenario Outline:US023 TC02 Staff hastaya dr atamasi ve status durumunu duzenler
    #Given FK url e gider
    And FK Kullanici logine tiklar
    And FK Kullanici SignIn olur
    Given FK kullanici admin olarak "<username>" ve "<password>" ile giris yapar
    And FK SigninEnterTusu butonuna tiklar
    Then FK Kullanici My Pages menu butonuna tiklar
    And FK Kullanici Search Patient butonuna tiklar
    Then FK Kullanici patient ssn kutusuna gecerli bir "<SSN>" numara girer
    And FK ShowAppointmentsButton a tiklar
    Then FK Kullanici Edit butonuna tiklar
    And FK Kullanici Status dropdown elementini PENDING, COMPLETED veya CANCELLED seklinde secer
    Then FK Kullanici Physician bolumunden dr atamasi yapar
    And FK Kullanici save butonuna ile tiklar
    Then FK Kullanici signOut olur
    And ucsaniye bekle
    Examples:
      |username | password |SSN|
      |stafffurkan2|Medunna.82 |111-37-3773|

Scenario Outline:US023 TC05 Staff fatura olusturur ve tekrar goruntuleyebilir
  #Given FK url e gider
  And FK Kullanici logine tiklar
  And FK Kullanici SignIn olur
    Given FK kullanici admin olarak "<username>" ve "<password>" ile giris yapar
    And FK SigninEnterTusu butonuna tiklar
    Then FK Kullanici My Pages menu butonuna tiklar
    And FK Kullanici Search Patient butonuna tiklar
    Then FK Kullanici patient ssn kutusuna gecerli bir "<SSN>" numara girer
    And FK ShowAppointmentsButton a tiklar
    Then FK Kullanici paymantinvoiceproces tiklar
 # And Kullanici createinvoice e tikar
    Then FK Kullanici ShowInvoiceButton tiklar
  Then FK Kullanici signOut olur
  And ucsaniye bekle
    Examples:
      |username|password|SSN|
      |stafffurkan2|Medunna.82  |111-47-4785|


#Feature: Medunna Health US23 TC03

 Scenario Outline:DoktorLaboratuvar iste
 #Given FK url e gider
   And FK Kullanici logine tiklar
   And FK Kullanici SignIn olur
  Given FK kullanici admin olarak "<username>" ve "<password>" ile giris yapar
  And FK SigninEnterTusu butonuna tiklar
  And FK Kullanici My Pages menu butonuna tiklar
  Then FK Kullanici menuden My Appointment secenegini secer
  Then FK Kullanici Edite butonuna tiklar
  And FK Kullanici Request a test butonuna tiklar
  Then FK Kullanici urea,sodium ve glucose butonlarina tiklar
  And FK Kullanici save butonuna ile tiklar
   Then FK Kullanici signOut olur
   And ucsaniye bekle

  Examples:
    |username|password|
    |drfurkan1  |Medunna.82|


  Scenario Outline:US023 TC04 Dr hastayi tedavi eder durumunu comleted a cevirir
    Given FK url e gider
    And FK Kullanici logine tiklar
    And FK Kullanici SignIn olur
   Given FK kullanici admin olarak "<username>" ve "<password>" ile giris yapar
   And FK SigninEnterTusu butonuna tiklar
   Then FK Kullanici My Pages menu butonuna tiklar
   And FK Kullanici menuden My Appointment secenegini secer
   Then FK Kullanici Edit butonuna tiklar
   And FK Kullanici Status dropdown elementini PENDING, COMPLETED veya CANCELLED seklinde secer
   Then FK Kullanici  Anamnesis textbox a tiklar
   And FK Kullanici  Anamnesis  textbox a bilgi girer
   Then FK Kullanici  Treatment   textbox a tiklar
   And FK Kullanici  Treatment  textbox a bilgi girer
   Then FK Kullanici  Diagnosis  textbox a tiklar
   And FK Kullanici  Diagnosis  textbox a bilgi girer
    And FK Kullanici save butonuna ile tiklar
   And FK Kullanici sayfayi kapatir

   Examples:

     |username|password|
     |drfurkan1  |Medunna.82|