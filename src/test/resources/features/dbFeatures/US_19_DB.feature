Feature: us19
  @tc19db
  Scenario: tc19
    Given Kullanici  db ye baglanir
    Then Kullanici select "*" from "staff" sorgusu yapar
    And Kullanici "first_name" sutunu okur
    Then kullanici "staff" table "first_name" sutunundaki "furkan" dogrular