package test.java.deckofcards;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import main.java.api.EndPoints;
import main.java.api.Keys;
import main.java.deck.Deck;
import main.java.deck.DeckType;
import main.java.deck.Decks;

/**
 * Tests to create a deck
 * 
 * @author sudhipm
 *
 */
public class CreateDeckTests {
	
	private Deck deck;
	
	/*
	 * Test to create a new deck without jokers and validate the response
	 * 
	 */
	@Test(groups = {"jokers_disabled", "deck_without_jokers"})
	public void createNewDeckTest() {
		String endPoint = EndPoints.newDeck(false);
		Response response = RestAssured.get(endPoint);
		response.print();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
		String deckId = response.jsonPath().getString(Keys.DECK_ID.getKey());
		int cardsRemaining = response.jsonPath().getInt(Keys.REMAINING.getKey());
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertNotNull(deckId, "Deck not created");
		softAssert.assertEquals(cardsRemaining,  DeckType.DECK_WITHOUT_JOKERS.getValue());
		softAssert.assertTrue(response.jsonPath().getBoolean(Keys.SUCCESS.getKey()), "Unsuccessful");
		softAssert.assertFalse(response.jsonPath().getBoolean(Keys.SHUFFLED.getKey()), "Deck is shuffled");
		softAssert.assertAll();
		
		deck = new Deck(deckId, cardsRemaining);
		Decks.setDeck(DeckType.DECK_WITHOUT_JOKERS, deck);
	}
	
	/*
	 * Test to create a new deck with jokers and validate the response
	 * 
	 */
	@Test(groups = {"jokers_enabled", "deck_with_jokers"})
	public void createNewDeckWithJokersTest() {
		String endPoint = EndPoints.newDeck(true);
		
		/*
		 * JSONObject body = new JSONObject(); 
		 * body.put("jokers_enabled", true);
		 * body.put("shuffled", false);
		 * 
		 * Response response = 
		 * RestAssured. 
		 * given(). 
		 * 	contentType(ContentType.JSON).
		 * body(body.toString()).post(EndPoints.newDeck()); 
		 * response.print();
		 */
		
		Response response = RestAssured.get(endPoint);
		response.print();
		
		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
		String deckId = response.jsonPath().getString(Keys.DECK_ID.getKey()); 
		int cardsRemaining = response.jsonPath().getInt(Keys.REMAINING.getKey());
  
		SoftAssert softAssert = new SoftAssert(); softAssert.assertNotNull(deckId, "Deck not created"); 
		softAssert.assertEquals(cardsRemaining, DeckType.DECK_WITH_JOKERS.getValue());
		softAssert.assertTrue(response.jsonPath().getBoolean(Keys.SUCCESS.getKey()), "Unsuccessful");
		softAssert.assertFalse(response.jsonPath().getBoolean(Keys.SHUFFLED.getKey()), "Deck is shuffled"); softAssert.assertAll();
  
		deck = new Deck(deckId, cardsRemaining); 
		Decks.setDeck(DeckType.DECK_WITH_JOKERS, deck);			 
	}

}
