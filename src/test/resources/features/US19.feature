Feature: US_19

Scenario:TC_01
   Given Admin url'e gider.
   Then Admin insan ikonuna tiklar
   Then Admin signin sekmesine tiklar
   Then Admin bir  username saglar
   Then Admin bir password saglar
   Then Admin sign in buttonuna tiklar
   Then Admin items-titles'e butonuna tiklar
   Then Admin acilan sekmede Staff'a tiklar
   And  Admin Create a new Staff'a tiklar
   And  Admin Snn girer
   And  Admin Use Search tiklar
   And  Admin  Search User 'a tiklar


Scenario:TC_02
   Given Admin url'e gider.
   Then Admin insan ikonuna tiklar
   Then Admin signin sekmesine tiklar
   Then Admin bir  username saglar
   Then Admin bir password saglar
   Then Admin sign in buttonuna tiklar
   Then Admin items-titles'e butonuna tiklar
   Then Admin acilan sekmede Staff'a tiklar
   Then  Admin acilan sayfada son sayfaya gider
   Then  Admin kayitli Staff'in Editine tiklar
   Then  Admin bos alanlari doldurur
   # And  Sayfayi kapatir

   Scenario: TC_03
      Given Admin url'e gider.
      Then Admin insan ikonuna tiklar
      Then Admin signin sekmesine tiklar
      Then Admin bir  username saglar
      Then Admin bir password saglar
      Then Admin sign in buttonuna tiklar
      Then Admin items-titles'e butonuna tiklar
      Then Admin acilan sekmede Staff'a tiklar
      Then Admin acilan sayfada son sayfaya gider
      Then Admin kayitli Staffta view'e tiklar
     # And Sayfayi kapatir

      Scenario: TC_04
         Given Admin url'e gider.
         Then Admin insan ikonuna tiklar
         Then Admin signin sekmesine tiklar
         Then Admin bir  username saglar
         Then Admin bir password saglar
         Then Admin sign in buttonuna tiklar
         Then Admin items-titles'e butonuna tiklar
         Then Admin acilan sekmede Staff'a tiklar
         And  Admin kayitli staffi delete eder
        # And  Sayfayi kapatir

