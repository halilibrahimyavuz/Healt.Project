Feature: US17 API ile Test-Item olusturma

  @api1
  Scenario Outline: Test-Items
    * YE gerekli path paramsları oluşturur
    * YE expected "<name>", "<description>", <price>, "<defaultValMin>", "<defaultValMax>" dataları girer
    * YE request gonderir ve respons alir
    * YE API ile test adimini dogrular

    Examples:
      |name   |description |price|defaultValMin|defaultValMax|
      |kan11|anemic1     |341  |451            |671          |