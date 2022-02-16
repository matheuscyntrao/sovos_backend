Feature: Create and edit user

  Scenario Outline: Check all rules to create and edit an user
    Given i setup data to create and edit an user:
      | name                   | gender   | email   | status   |
      | <name>                 | <gender> | <email> | <status> |
    When i execute the request to create and edit an user
    And i setup data to edit an user:
      | name                   |  email                    | status   |
      | Usuário Editadd        |  EMAIL_GENERATOR    | active   |
    Then i verify if status code is "<statusCode>" after edit an user
    And i check if the "<message>" is correctly if an error exists after update user

    Examples:
      | statusCode | name                   | gender     | email                          | status   | message |
      | 200        |  Tenalo Ramakrishna    |   male     | EMAIL_GENERATOR                |  active  |         |

