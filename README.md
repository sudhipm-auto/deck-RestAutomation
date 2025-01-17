# deck-RestAutomation is a repo to test the API: http://deckofcardsapi.com using TestNG and RestAssured

Structure:
---------
- src->main->java->api (Generate endpoint URLs and the response keys enumerator)
- src->main->java->deck (Deck data and Deck type) 
- src->test->data (TestNG XMLs to run the scripts)
- src->test->java (Automated tests to create deck and draw cards)

How to run the tests
--------------------
Method 1 (Run tests individually):
1. Create a new deck of cards: Run deckofcards.CreateDeckTests.java -> createNewDeckTest() as TestNG
2. Support adding Jokers: Run deckofcards.CreateDeckTests.java -> createNewDeckWithJokersTest() as TestNG
3. Draw one or more cards from the deck
  - Run deckofcards.DrawFromDeckTests.java -> drawCardsFromDeckWithoutJokersTest() as TestNG (Pre-requisite: Deck should be created using 1)
  - Run deckofcards.DrawFromDeckTests.java -> drawCardsFromDeckWithJokersTest() as TestNG (Pre-requisite: Deck should be created using 2)
  
Method 2 (Run tests using XML to automatically create the deck before drawing cards):
1. Run test -> data -> Tests_Without_Jokers.xml as TestNG 
2. Run test -> data -> Tests_With_Jokers.xml as TestNG





