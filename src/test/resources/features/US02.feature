Feature: US_02
  Background: US02_TC01
    Given Giris sayfasina gidilir.
    And Account menu butonu tiklanir.
    And Register butonuna tiklar.
    And Registration sayfasi gorulur.

  Scenario Outline: : US002 TC001
    Then Firstname bos birakilamayacagi gorulur
    And   Firstname uygun sekilde doldurulur "<firstname>"
    Then Lastname bos birakilamayacagini gorur.
    And "<lastname>" uygun doldurulur

    Examples:
      |firstname   |lastname  |
      |rabia    |rabia    |



 # Scenario Outline: US002 TC003
  #  Then "<Email>" adresi @ karakteri icerdigi test edilir
  #  Then Email . karakterini test eder

   # Examples:
    #  |Email       |
    # |rabiagmail|
      #|rabia@gmailcom|
      #|rabia@gmail.com|


 # Scenario: US002 TC004
  #  Then Email adresinin bos birakilamayacagi test edilir