Feature: Calculator Tests
  Scenario: Check addition
    Given I am on calculator app page
    When I add "10.5" and "13"
    Then I got result "23.5"
    When I add "123e-5" and "4.23"
    Then I got result "4.23123"
    When I add "-23" and "30"
    Then I got result "7"
    When I add "-45.083" and "-12"
    Then I got result "-57.083"

  Scenario: Check subtraction
    Given I am on calculator app page
    When I subtract "104" and "24"
    Then I got result "80"
    When I subtract "-24" and "24.31"
    Then I got result "-48.31"
    When I subtract "10,23" and "-75"
    Then I got result "85.23"
    When I subtract "-3" and "-7"
    Then I got result "4"

  Scenario: Check multiplication
    Given I am on calculator app page
    When I multiple "0,25" and "0,25"
    Then I got result "0.0625"
    When I multiple "1e2" and "0.002"
    Then I got result "0.2"
    When I multiple "8" and "2"
    Then I got result "16"
    When I multiple "-2" and "6"
    Then I got result "-12"

  Scenario: Check deviation
    Given I am on calculator app page
    When I divide "-248" and "-2"
    Then I got result "124"
    When I divide "02" and "2"
    Then I got result "1"
    When I divide "0.5" and "2"
    Then I got result "0.25"
    When I divide "2.0" and "4.0"
    Then I got result "0.5"

  Scenario: Check all operations for same x and y
    Given I am on calculator app page
    When I add "+100" and "100"
    Then I got result "200"
    When I change operations to "X-Y"
    Then I got result "0"
    When I change operations to "X/Y"
    Then I got result "1"
    When I change operations to "X*Y"
    Then I got result "10000"

  Scenario: Handling infinity
    Given I am on calculator app page
    When I divide "1e2" and "0"
    Then I got result "Infinity"
    When I divide "Infinity" and "1"
    Then I got result "Infinity"
    When I change operations to "X-Y"
    Then I got result "Infinity"
    When I change operations to "X+Y"
    Then I got result "Infinity"
    When I change operations to "X*Y"
    Then I got result "Infinity"
    When I multiple "Infinity" and "0"
    Then I got result "NaN"
    When I multiple "Infinity" and "Infinity"
    Then I got result "Infinity"
    When I multiple "-Infinity" and "Infinity"
    Then I got result "-Infinity"
    When I change operations to "X-Y"
    Then I got result "-Infinity"
    When I change operations to "X+Y"
    Then I got result "NaN"

  Scenario: Check forbidden signs
    Given I am on calculator app page
    When I divide "NaN" and "0"
    Then I got result "NaN"
    When I multiple "półtora" and "5"
    Then I got result "NaN"
    When I add "(2+3)" and "12"
    Then I got result "NaN"
    When I add "dwa" and "10"
    Then I got result "NaN"
