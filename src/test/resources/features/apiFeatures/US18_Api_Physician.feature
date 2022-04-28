@Main_physician_api
Feature:
  Scenario Outline:
    And  Admin BA  "https://medunna.com/api/physicians/" Medunna Api Endpointinden "<id>" numarali doktoru Okur Ve doktorun "<firstname>", "<lastname>","<ssn>","<examfee>", "<speciality>" Datalarina Sahip Oldugunu Dogrular.
    Examples:
      |id     |firstname|lastname|ssn        | examfee|speciality|
      |70010  |Cassio   |Lincoln |174-72-3014 | 226     |FAMILY_MEDICINE|
