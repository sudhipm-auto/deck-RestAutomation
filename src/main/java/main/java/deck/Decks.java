package main.java.deck;

/**
 * Class to hold the possible decks created by tests - Enables other tests to use an existing deck
 * 
 * @author sudhipm
 *
 */
public final class Decks {
	
	private static Deck deckWithoutJoker;
	private static Deck deckWithJokers;
	private static Deck partialDeck;
	
	public static void setDeck(DeckType deckType, Deck deck) {
		switch(deckType) {
		case DECK_WITH_JOKERS:
			deckWithJokers = deck;
			break;
		case PARTIAL_DECK:
			partialDeck = deck;
			break;
		default:
			deckWithoutJoker = deck;
		}
	}
	
	public static Deck getDeckWithoutJokers() {
		return deckWithoutJoker;
	}
	
	public static Deck getDeckWithJokers() {
		return deckWithJokers;
	}
	
	public static Deck getPartialDeck() {
		return partialDeck;
	}
}
