package api;

/**
 * Class to generate end point using the base URI
 * 
 * @author sudhipm
 *
 */
public final class EndPoints {
	
	public static final String BASE_URI = "https://deckofcardsapi.com/api/deck";
	
	private EndPoints() {
		//To restrict instantiation
	}

	/**
	 * Constructs the end point using {@link #BASE_URI}, resource path and query parameter.
	 * 
	 * @param deckCount
	 * @return EndPoint URI as String
	 */
	public static String newShuffle(int deckCount) {
		return BASE_URI + "/new/shuffle/?deck_count=" + deckCount;
	}
	
	/**
	 * Constructs the end point using {@link #BASE_URI} and resource path.
	 * 
	 * <p>When jokers enabled, adds query parameter<p>
	 * 
	 * @param jokersEnabled
	 * @return Endpoint URI as String
	 */
	public static String newDeck(boolean jokersEnabled) {
		String uri = "/new/";
		if(jokersEnabled) {
			uri = uri + "?jokers_enabled=" + jokersEnabled;
		}
		System.out.println(BASE_URI + uri);
		return BASE_URI + uri;
	}
	
	/**
	 * Constructs the end point using {@link #BASE_URI}, resource path and query parameter.
	 * 
	 * @param count
	 * @param deckId
	 * @return Endpoint URI as String
	 */
	public static String drawCards(String deckId, int count) {
		return BASE_URI + "/" + deckId + "/draw/?count=" + count;
	}

}
