Feature: Test address

  Scenario: Shopping
    Given I am on main site to start shopping
    When Click on signIn T
    Then Redirect after click SignIn T to 'https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account'
    When I am login T as 'xahafo1240@jwsuns.com' and 'g94n2_:Vc.VrW9i'
    Then Redirection after login T to 'https://mystore-testlab.coderslab.pl/index.php?controller=my-account'

    When  I am choosing a sweater
    Then Redirection after selecting the sweater to 'https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s'
    And I am choosing the quantity
    And I am adding the product to the cart
    And Click on Checkout
    Then I am checking if I am on the cart page with the order 'https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show'
    When Click Proceed to checkout
    Then I am checking the order on  'https://mystore-testlab.coderslab.pl/index.php?controller=order'
    And I am confirming the address
    And I am choosing the pickup method - PrestaShop "pick up in store"
    And I am choosing the payment option - Pay by Check
    And Click on Place Order
    Then Redirection to 'https://mystore-testlab.coderslab.pl/index.php?controller=order'
    Then I am taking a screenshot of the order confirmation and the amount
