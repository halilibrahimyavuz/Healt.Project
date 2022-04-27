Feature: api test item creation

  @ApiTestItem
  Scenario Outline: api test item creation
    * user gerekli path parametreleri ayarlar
    * user expected datalari ayarlar "<name>", "<description>", "<price>", "<defMinVal>", "<defMaxVal>"
    * user the post request and gets the response gonderir
    * user all api records dogrular

    Examples: test data
      |name|description|price|defMinVal|defMaxVal|
      |H1bAc9|5 AYLIK SEKER|580|2       |16       |