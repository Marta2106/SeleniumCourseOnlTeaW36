Feature: Test address

  Scenario Outline: Adding new address
    Given I am on main site
    When Click on signIn
    Then Redirect after click SignIn to 'https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account'
    When I am login as 'xahafo1240@jwsuns.com' and 'g94n2_:Vc.VrW9i'
    Then Redirection after login to 'https://mystore-testlab.coderslab.pl/index.php?controller=my-account'
    When I am entering to addresses
    Then Redirection after addresses button 'https://mystore-testlab.coderslab.pl/index.php?controller=addresses'
    When I am creating new address
    Then Redirection after new address button 'https://mystore-testlab.coderslab.pl/index.php?controller=address'
    When I am filling the form "<address>" "<city>" "<zipCode>"
    And I am confirming date
    Then Redirection after new save button 'https://mystore-testlab.coderslab.pl/index.php?controller=addresses'
    Examples:
      | address | city | zipCode |
      | ul. Szklana 1| Olsztyn | 10-100 |
