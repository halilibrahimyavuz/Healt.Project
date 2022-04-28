@database_physician_18
Feature: US18_TC11_database

     Scenario: TC_0011_Physician_reads_information
      * Admin B_A connects to the database
      * Admin B_A gets the "*" from "physician" table
      * Admin B_A reads all of the "first_name" column data
      * Admin B_A verify "physician" table "first_name" column contains "Cassio"
      * Admin B_A close the database connection
