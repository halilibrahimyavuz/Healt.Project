Feature: DB ile oda bilgilerini dogrulama

  Scenario:


  Scenario Outline: TC08

    #Given Kullanici dataBase e baglanir
    #And Kullanici "c_test_item " tablosundan "*" satirlarini getirir
    #Then kullanici "<id>" numarali kisinin "<table>" tablosundaki bilgilerini kaydeder ve dogrular
    #Then kullanici "<id>" e sahip kisinin "<table>" tablosundaki bilgilerini kaydeder ve dogrular
    Examples:
      | id | table |
      | "72790" | c_test_item |

  @db_login_name
  Scenario: read user information
    Given user connectts to the database
    And user gets the "*" from "jhi_user" table
      # Select * from jhi_user
    And user read all of the "login" column data
    And verify "jhi_user" table "login" column contains "muratdoctor"
      # And verify "country" table "name column contains "senegal"
      # And verify "c_test_item" table "name column contains "Potassium"

    Then close the database connection


    # bunlara bakarak yapmaya calis