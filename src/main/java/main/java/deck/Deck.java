package main.java.deck;

/**
 * Class for the Deck object with getters and setters
 * 
 * @author sudhipm
 *
 */
public final class Deck {
	
	private String deckId;
	private int remainingCards;
	
	public Deck() {}
	
	public Deck(String deckId) {
		this.deckId = deckId;
	}
	
	public Deck(String deckId, int remainingCards) {
		this(deckId);
		this.remainingCards = remainingCards;
	}
	
	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}
	
	public String getDeckId() {
		return deckId;
	}
	
	public void setRemainingCards(int remainingCards) {
		this.remainingCards = remainingCards;
	}
	
	public int getRemainingCards() {
		return remainingCards;
	}
}
