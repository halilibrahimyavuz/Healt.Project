  Feature: Kullanici, API kullanarak ileti olusturmayi ve okumayi dogrulamalidir

      # Eger datayı silerlerse calismiyor dikkat et !!!
    Scenario:  TC01 Kullanici, API Kullanarak Mesajlari Okuyabilmeli ve Okudugunu Dogrulamalidir
      Given TY Kullanici "https://www.medunna.com/api/c-messages" Medunna Api Endpointinden Mesajlari Okur
      Then TY Kullanici "https://www.medunna.com/api/c-messages" Medunna Api Endpointinden Mesajlari Okuma Isleminin Status Codeunun 200 Oldugunu Dogrular
      And TY Kullanici "https://www.medunna.com/api/c-messages" Medunna Api Endpointinden id Numarali Mesaji Okur Ve Mesajin name, email, subject, message Datalarina Sahip Oldugunu Dogrular
      |id   |name            |email          |subject            |message            |
      |87623|Name Test Datasi|test@test.com  |Subject Test Datasi|Message Test Datasi|
      |87647|Name Lorem Ipsum|lorem@ipsum.com|Subject Lorem Ipsum|Message Lorem Ipsum|
      |83288|Mrs. Emile Kunze|jerrell.hirthe@hotmail.com|Optio accusamus ea quia quas eos.|Adipisci et et est cumque impedit sed laboriosam.|

   # Yukaridaki data table calistigi icin scenario outline'a ihtiyacim kalmadi
   #Scenario Outline:
   #  And TY Kullanici "https://www.medunna.com/api/c-messages" Medunna Api Endpointinden "<id>" Numarali Mesaji Okur Ve Mesajin "<name>", "<email>", "<subject>", "<message>" Datalarina Sahip Oldugunu Dogrular.
   #  Examples:
  #    |id   |name            |email        |subject            |message            |
    #    |87623|Name Test Datasi|test@test.com|Subject Test Datasi|Message Test Datasi|

Scenario Outline: TC02 Kullanici, API Kullanarak Mesaj Olusturabilmeli ve Mesajin Olustugunu Dogrulayabilmeli
  Given TY Kullanici "https://www.medunna.com/api/c-messages" Medunna Api Endpointine, "<name>", "<email>", "<subject>", "<message>" Datalarini Kullanarak Yeni Mesaj Olusturur
  Then TY Kullanici "https://www.medunna.com/api/c-messages" Medunna Api Endpointine, "<name>", "<email>", "<subject>", "<message>" Datalarini Kullanarak Olusturdugu Mesajin Status Codeunun 201 Oldugunu Dogrular
  And TY Kullanici "https://www.medunna.com/api/c-messages" Medunna Api Endpointine, "<name>", "<email>", "<subject>", "<message>" Datalarini Kullanarak Olusturdugu Mesajin Olustugunu Dogrular

  Examples:
    | name | email        | subject        | message   |
    | Ali  |ali@gmail.com |Temizlik        |Lorem Ipsum|
    | Veli |veli@gmail.com|Hizmet          |Lorem Ipsum|
    | Ayse |ayse@gmail.com|Customer Service|Lorem Ipsum|