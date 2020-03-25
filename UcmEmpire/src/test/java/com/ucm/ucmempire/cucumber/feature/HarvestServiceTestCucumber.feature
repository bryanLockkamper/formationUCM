Feature: Harvest Service

  Scenario: Normal case
    Given a Player name:y|id:1
    And 3 Farmers who have 10 pa each and 10 hp and belongs to player 1
    And Farmers are on a Square with 200 "Stone" Resource
    When I end my turn Farmers have to harvest as much resource as their number of action point
    Then the result should be 30
