Feature: Create users

  Scenario Outline: Check all rules to create an user
    Given i setup data to create an user:
      | name                   | gender   | email   | status   |
      | <name>                 | <gender> | <email> | <status> |
    When i execute the request to create an user
    Then i verify if status code is "<statusCode>" after create an user
    And i check if the "<message>" is correctly if an error exists after create an user

    Examples:
      | statusCode | name                   | gender     | email              | status   | message |
      | 201        |  Tenali Ramakrishna    |   male     | EMAIL_GENERATOR    |  active  |         |
      | 201        |  Talita Hiroshima11    |   female   | EMAIL_GENERATOR    |  active  |         |

