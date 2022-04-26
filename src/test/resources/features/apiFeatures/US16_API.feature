Feature: API ile oda olusturma, okuma, güncelleme ve silme dogrulanmali.

  Scenario: TC01 Kullanici, API Kullanarak Mesajlari Okuyabilmeli ve Okudugunu Dogrulamalidir
    Given TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointinden Roomlari Goruntuler
    Then TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointinden Roomlari Goruntuleme Isleminin Status Codeunun 200 Oldugunu Dogrular
    And TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointinden id Numarali Mesaji Okur Ve Mesajin roomNumber, roomType, status, price, description Datalarina Sahip Oldugunu Dogrular
    |id   |roomNumber|roomType      |status|price|description          |
    |88264|52025     |PREMIUM_DELUXE|true  |10000|Lorem Ipsum Good Luck|
    |88265|34440     |SUITE         |true  |100  |Lorem Ipsum Crowded  |
    |88266|888420    |TWIN          |true  |19   |Lorem Ipsum Dear     |

    Scenario Outline: TC02 Kullanici, API Kullanarak Room Olusturabilmeli ve Roomun Olustugunu Dogrulayabilmeli
      Given TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointine, "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Yeni Room Olusturur
      Then TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointine, "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Olusturdugu Mesajin Status Codeunun 201 Oldugunu Dogrular
      And TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointine, "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Roomun Olustugunu Dogrular
      And TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointine, "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Olusturdugu Roomun ID sini alir Ve Bu IDyi Kullanarak Roomu Siler

      Examples:
       |roomNumber|roomType|status|price|description                |
       |39121529  |SUITE   |false |199  |Lorem Ipsum Family Room    |
       |55121914  |DAYCARE |true  |118  |Lorem Ipsum Stable Patient |
       |12155919  |DELUXE  |false |57   |Lorem Ipsum Surgery Patient|

    Scenario Outline: TC03 Kullanici, API Kullanarak Bir Roomu Guncelleyeilmeli ve Roomun Guncellendigini Dogrulayabilmeli
      Given TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki "<id>" Numarali Odayi Goruntuler
      Then TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki "<id>" Numarali Odayi, "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Update Eder
      Then TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki "<id>" Numarali Oda Icin, "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Yaptigi Updatein Status Codeunun 200 Oldugunu Dogrular
      And TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki "<id>" Numarali Odayi,  "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Roomun Update Edildigini Dogrular

      Examples:
       |id   |roomNumber|roomType|status|price|description          |
       |88272|500001    |SUITE   |false |250  |Tadilat Tamamlandi   |
       |88273|500002    |DAYCARE |true  |118  |Kardiyoloji Servisi  |
       |88274|500003    |DELUXE  |false |57   |Pediatrik Dermatoloji|

    Scenario Outline: TC04 Kullanici, API Kullanarak Bir Roomu Silebilmeli ve Roomun Silindigini Dogrulayabilmeli
      Given TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointine, "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Yeni Room Olusturur
      Given TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki  "<roomNumber>", "<roomType>", "<status>", "<price>", "<description>" Datalarini Kullanarak Olusturulan Odanin id Numarasini Alir
      Then TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki id Numarasini Aldigi Odayi Siler
      Then TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki id Numarasini Aldigi Odayi Silme Islemi Icin Status Codeun 204 Oldugunu Dogrular
      #And TY Kullanici "https://www.medunna.com/api/rooms" Medunna Api Endpointindeki id Numarasini Aldigi Odayi Yeniden Goruntulemek Istediginde Status Codeun 204 Oldugunu Dogrular

      Examples:
       |roomNumber|roomType|status|price|description                |
       |391215529 |SUITE   |true  |142  |Lorem Ipsum Lovely Room    |
