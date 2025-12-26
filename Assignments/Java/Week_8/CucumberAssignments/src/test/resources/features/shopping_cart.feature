@cart
Feature: Shopping Cart Management
  As an online shopper
  I want to manage items in my shopping cart
  So that I can purchase the products I need

  Background:
    Given the user is logged in
    And the product catalog is available

  @smoke
  Scenario: Add single item to cart
    # TODO: Write the scenario
    Given the user is on a product page
    When the user clicks add to cart
    Then the item appears in cart
    And the cart count updates

  Scenario: Add multiple quantities of an item
    # TODO: Write the scenario
    # Consider quantity selector interaction

  Scenario: View cart contents
    # TODO: Write the scenario
    # Include verification of item details shown

  Scenario: Update item quantity in cart
    # TODO: Write the scenario
    # Include before/after quantity and price verification

  Scenario: Remove item from cart
    # TODO: Write the scenario
    # Verify item no longer appears and price updates

  Scenario: Empty cart displays message
    # TODO: Write the scenario
    # Verify appropriate message when cart is empty

  Scenario: Cart total calculates correctly
    Given the user has the following items in cart:
      | Product     | Price  | Quantity |
      | Widget A    | 10.00  | 2        |
      | Widget B    | 25.00  | 1        |
    Then the cart subtotal should be "$45.00"