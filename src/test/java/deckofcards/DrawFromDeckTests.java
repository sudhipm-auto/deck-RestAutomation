package deckofcards;

import api.EndPoints;
import api.Keys;
import deck.Deck;
import deck.DeckType;
import deck.Decks;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Tests to draw cards from a deck
 * 
 * @author sudhipm
 *
 */
public class DrawFromDeckTests {
	
	/**
	 * Common method to validate the response after drawing cards from the deck
	 * 
	 * @param deck
	 * @param drawCards
	 */
	public void drawCardsFromDeckAndValidateResponse(Deck deck, DeckType deckType, int drawCards) {
		String endPoint = EndPoints.drawCards(deck.getDeckId(), drawCards);
		Response response = RestAssured.get(endPoint);
		response.print();
		
		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
		String deckId = response.jsonPath().getString(Keys.DECK_ID.getKey());
		int cardsRemaining = response.jsonPath().getInt(Keys.REMAINING.getKey());

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(deckId,  deck.getDeckId(), "Incorrect deck");
		softAssert.assertEquals(cardsRemaining,  deckType.getValue() - drawCards, "Remaining cards is incorrect");
		softAssert.assertAll();
		
		deck.setRemainingCards(cardsRemaining);
	}
	
	/*
	 * Test to draw cards from the deck without jokers and validate the response 
	 * 
	 * Note: Test depends on the base group to create a deck without jokers
	 * 
	 */
	@Test(dependsOnGroups = "deck_without_jokers", groups = "jokers_disabled")
	public void drawCardsFromDeckWithoutJokersTest() {
		int cardsToDraw = 2;
		Deck deck = Decks.getDeckWithoutJokers();
		drawCardsFromDeckAndValidateResponse(deck, DeckType.DECK_WITHOUT_JOKERS, cardsToDraw);
	}
	
	/*
	 * Test to draw cards from the deck with jokers and validate the response 
	 * 
	 * Note: Test depends on the base group to create a deck with jokers
	 * 
	 */
	@Test(dependsOnGroups = "deck_with_jokers", groups = "jokers_enabled")
	public void drawCardsFromDeckWithJokersTest() {
		int cardsToDraw = 2;
		Deck deck = Decks.getDeckWithJokers();
		drawCardsFromDeckAndValidateResponse(deck, DeckType.DECK_WITH_JOKERS, cardsToDraw);
	}

}
