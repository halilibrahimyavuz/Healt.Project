
Feature: US25Api Test

  @us25api
  Scenario Outline: TC-01 randevu

    * kullanici gerekli path params ayarlari yapar
    * kullanici expected datalari girer "<firstname>" "<lastname>" "<Ssn>" "<email>" "<phone>" "<startDate>"
    * kullanici reguest gonderir ve response alir
    * kullanici Api kayitlarini dosyaya kaydeder
    * kullanici Api kayitlari dogrular

    Examples:
      |firstname|lastname |Ssn|email|phone|startDate|
      |Mehmet123  |mehmet1234 |3425-69-0249|hello1253@gmail.com|555-444-6666|25.04.2022|


