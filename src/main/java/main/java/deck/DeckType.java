package main.java.deck;

/**
 * Enumerator with possible deck types and appropriate cards in the deck as the value
 * 
 * @author sudhipm
 *
 */
public enum DeckType {
	
	DECK_WITHOUT_JOKERS(52), DECK_WITH_JOKERS(54), PARTIAL_DECK(0);
	
	private int totalCards;
	
	private DeckType(int totalCards) {
		this.totalCards = totalCards;
	}
	
	public int getValue() {
		return totalCards;
	}
	

}
