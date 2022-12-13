Feature: Empty_Cart

@Search
Scenario Outline:Search Product

Given user is on "<URL>"
And user search for "<Product>"
Then user verify results that every product titles has "<Word>"
Then user adds last items to Cart
Then user clicks on Empty Cart

Examples:
|URL|Product|Word|
|URL1| Stainless Steal Table| Table|