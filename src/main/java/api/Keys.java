package api;

/**
 * Enumerator with possible keys in response
 * 
 * @author sudhipm
 *
 */
public enum Keys {
	
	SUCCESS("success"),
	DECK_ID("deck_id"),
	SHUFFLED("shuffled"),
	JOKERS_ENABLED("jokers_enabled"),
	REMAINING("remaining"),
	CARDS("cards"),
	PILES("piles");
	
	private String key;
	
	private Keys(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
}
