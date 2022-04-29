Feature: US_01

  @US_01_TC01
  Scenario Outline: US_01_positive_Scenario
      Given Giris sayfasina gidilir.
      And Account menu butonu tiklanir.
      And Register butonuna tiklar.
      And Registration sayfasi gorulur.
      Then Geceli "<ssn>" ssn girilir.

      Examples:
        |ssn        |
        |999-99-9999|

    @US_01_TC02_TC03_TC04_TC05_TC06
    Scenario Outline: TC02_negative_Scenario
      Given Giris sayfasina gidilir.
      And Account menu butonu tiklanir.
      And Register butonuna tiklar.
      And Registration sayfasi gorulur.
      Then Gecesiz "<ssn>" girilir.
      Then Gecersiz ssn mesaji gorulur.

    Examples:
      |ssn       |
      |999-99-999|
      |000-99-9999|
      |999-999999|






















