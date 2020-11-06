package api;

public class Constants {

    public static final String GIPHY_BASE_URL = "https://api.giphy.com/v1/gifs/";
    public static final String GIPHY_API_KEY = "api_key=pMbJMxIMfv63YspJOuEZ8v0uKJQNr3vS";
    public static final String GIPY_ENDPOINT_SEARCH = "search";
    public static final String GIPHY_ENDPOINT_CATEG = "categories";
    public static final String GIPHY_PARAM_TERM = "q=car";
    public static final String GIPHY_PARAM_NMR_RETURN = "limit=5";
    public static final String validSearchRequest = GIPHY_BASE_URL + Constants.GIPY_ENDPOINT_SEARCH + "?"
            + Constants.GIPHY_API_KEY + "&" + Constants.GIPHY_PARAM_TERM + "&" + Constants.GIPHY_PARAM_NMR_RETURN;
}
