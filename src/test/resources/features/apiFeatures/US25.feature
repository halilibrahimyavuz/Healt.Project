@us25api
Feature: US25Api Test


  Scenario Outline: TC-01 randevu

    * kullanici gerekli path params ayarlari yapar
    * kullanici expected datalari girer "<firstname>" "<lastname>" "<Ssn>" "<email>" "<phone>" "<startDate>"
    * kullanici reguest gonderir ve response alir
    * kullanici Api kayitlarini dosyaya kaydeder
    * kullanici Api kayitlari dogrular

    Examples:
      |firstname|lastname |Ssn|email|phone|startDate|
      |Mehmet  |Calismiyor |3178-69-0249|hello1253@gmail.com|509-444-66106|27.04.2022|


