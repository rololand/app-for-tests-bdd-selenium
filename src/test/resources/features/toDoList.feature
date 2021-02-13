Feature: To Do List Tests
  Scenario: Testing To Do List
    Given I am on to do list page
    When I add new task "Task 3"
    And I add new task "Task 4"
    And I add new task "Task 5"
    Then I got list of tasks
      |Task 5|Task 4|Task 3|Task 1|Task 2|
    When I mark as done task "Task 1"
    Then I got list of tasks
      |Task 5|Task 4|Task 3|Task 2|Task 1|
    And Task "Task 1" is marked as done
    When I mark as done task "Task 4"
    Then I got list of tasks
      |Task 5|Task 3|Task 2|Task 4|Task 1|
    And Task "Task 4" is marked as done
    When I delete task "Task 3"
    Then I got list of tasks
      |Task 5|Task 2|Task 4|Task 1|
    And I add new task "Task 6"
    Then I got list of tasks
      |Task 6|Task 5|Task 2|Task 4|Task 1|
    When I mark as done task "Task 6"
    Then I got list of tasks
      |Task 5|Task 2|Task 6|Task 4|Task 1|
    And Task "Task 6" is marked as done
    When I delete marked as done task "Task 4"
    Then I got list of tasks
      |Task 5|Task 2|Task 6|Task 1|