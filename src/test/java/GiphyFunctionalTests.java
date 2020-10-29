import org.testng.annotations.Test;

public class GiphyFunctionalTests extends FrontendActions {

    private void LoginUser() {

        clickButtonByXpath(Constants.GIPHY_LOGIN_BUTTON);
        fillInputFieldBySendKeys(Constants.GIPHY_LOGIN_EMAIL_FIELD, Constants.GIPHY_EMAIL);
        fillInputFieldBySendKeys(Constants.GIPHY_LOGIN_PASS_FIELD, Constants.GIPHY_PASSWORD);
        clickButtonByXpath(Constants.GIPHY_SIGNIN_BUTTON);
        validation.isTextPresent(Constants.GIPHY_USERNAME);
    }

    private void LogoutUser() {

        validation.isTextPresent(Constants.GIPHY_USERNAME);
        elementFocus(Constants.GIPHY_LOGGED_USERNAME);
        clickButtonByXpath(Constants.GIPHY_LOGOUT_BUTTON);
        validation.elementTextIsEqualByXpath(Constants.GIPHY_LOGIN_BUTTON, Constants.LOGIN_BUTTON);
    }

    /**
     * Searching for an existing GIF and validating
     * the search results include the entered GIF name.
     */
    @Test
    public void P_Search_ExistingGifName() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        fillInputFieldBySendKeys(Constants.GIPHY_SEARCH_FIELD, "Hello");
        clickButtonByXpath(Constants.GIPHY_SEARCH_BUTTON);
        validation.isTextPresent("Hello GIFs");
    }

    /**
     * Searching for an existing GIF by clicking 'Enter' from the keyboard and validating
     * the search results include the entered GIF name.
     */
    @Test
    public void P_SearchEnter_ExistingGifName() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        fillInputFieldBySendKeys(Constants.GIPHY_SEARCH_FIELD, "Good Morning");
        pressKeyboard(Constants.GIPHY_SEARCH_FIELD, "ENTER");
        validation.isTextPresent("Good Morning GIFs");
    }

    /**
     * Searching for a non existing GIF name and validating the error message.
     */
    @Test
    public void N_Search_NonExistingGifName() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        fillInputFieldBySendKeys(Constants.GIPHY_SEARCH_FIELD, helper.randomNumberGenerator());
        clickButtonByXpath(Constants.GIPHY_SEARCH_BUTTON);
        validation.isTextPresent(Constants.GIPHY_NOT_EXISTING_GIPHY_ERROR + fetchValueFromFrontend(Constants.GIPHY_SEARCH_FIELD));
    }

    /**
     * Logging in with invalid e-mail format and validating error message.
     */
    @Test
    public void N_Login_InvalidEmailFormat() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        clickButtonByXpath(Constants.GIPHY_LOGIN_BUTTON);
        fillInputFieldBySendKeys(Constants.GIPHY_LOGIN_EMAIL_FIELD, helper.randomSpecialCharsGenerator());
        pressKeyboard(Constants.GIPHY_LOGIN_EMAIL_FIELD, "TAB");
        validation.elementTextIsEqualByXpath(Constants.GIPHY_INVALID_EMAIL_POPUP, Constants.INVALID_EMAIL);
    }

    /**
     * Logging in with social links and validating page redirected correctly.
     */
    @Test
    public void P_Login_SocialLogin() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        clickButtonByXpath(Constants.GIPHY_LOGIN_BUTTON);
        clickButtonByXpath(Constants.GIPHY_LOGIN_APPLE);
        validation.isTextPresent("Apple ID");
    }

    /**
     * Checking user is logged in or not, if not->login is required.
     * Validating the logged user(username) is the expected one.
     * Uploading a valid GIF by url and validating by comparing actual and expected url.
     */
    @Test
    public void P_Upload_ValidGifByUrl() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        if (!validation.isTextPresent(Constants.GIPHY_USERNAME)) {
            LoginUser();
        }
        clickButtonByXpath(Constants.GIPHY_UPLOAD_BUTTON);
        fillInputFieldBySendKeys(Constants.GIPHY_UPLOAD_URL, Constants.GIPHY_VALID_URL);
        validation.elementValueIsEqual(Constants.GIPHY_URL_FIELD, Constants.GIPHY_VALID_URL);
        LogoutUser();
    }

    /**
     * Checking user is logged in or not, if not->login is required.
     * Validating the logged user(username) is the expected one.
     * Uploading an invalid GIF by url and validating the error message.
     */
    @Test
    public void N_Upload_InvalidGifByUrl() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        if (!validation.isTextPresent(Constants.GIPHY_USERNAME)) {
            LoginUser();
        }
        clickButtonByXpath(Constants.GIPHY_UPLOAD_BUTTON);
        fillInputFieldBySendKeys(Constants.GIPHY_UPLOAD_URL, helper.randomStringGenerator());
        validation.elementTextIsEqualByXpath(Constants.GIPHY_INVALID_URL_POPUP, Constants.GIPHY_UPLOAD_INVALID_URL_MESSAGE);
        LogoutUser();
    }

    /**
     * GIF url upload and create without logging in and validating error message.
     */
    @Test
    public void N_UploadCreate_NoLogin() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        clickButtonByXpath(Constants.GIPHY_CREATE_BUTTON);
        fillInputFieldBySendKeys(Constants.GIPHY_UPLOAD_URL, Constants.GIPHY_VALID_URL);
        validation.isTextPresent(Constants.GIPHY_CREATE_ERROR);
        clickButtonByXpath(Constants.GIPHY_RETURN_LINK);
        clickButtonByXpath(Constants.GIPHY_UPLOAD_BUTTON);
        validation.isTextPresent(Constants.GIPHY_UPLOAD_ERROR);
    }

    /**
     * Password reset by entering valid user email and validate message.
     */
    @Test
    public void P_ResetPasswordLink_ValidUser() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        clickButtonByXpath(Constants.GIPHY_LOGIN_BUTTON);
        clickButtonByXpath(Constants.PASSWORD_RESET_BUTTON);
        fillInputFieldBySendKeys(Constants.GIPHY_LOGIN_EMAIL_FIELD, Constants.GIPHY_EMAIL);
        clickButtonByXpath(Constants.SEND_EMAIL_BUTTON);
        validation.isTextPresent(Constants.RESET_CONFIRMATION);
    }

    /**
     * Navigate to all menu items and validating page redirected properly.
     * Searching for Reactions GIF
     */
    @Test
    public void P_Navigate_MenuItems() {
        navigateToPage(Constants.GIPHY_PAGE_URL);
        clickButtonByXpath(Constants.GIPHY_REACTIONS_MENU_ITEM);
        validation.isTextPresent("Reaction GIFs");
        fillInputFieldBySendKeys(Constants.GIPHY_SEARCH_FIELD, "Gatsby");
        clickButtonByXpath(Constants.GIPHY_SEARCH_BUTTON);
        sleep(2);
        validation.isTextPresent("Gatsby GIFs");
        clickButtonByXpath(Constants.GIPHY_ENTERTAINMENT_MENU_ITEM);
        validation.isTextPresent("Entertainment GIFs");
        clickButtonByXpath(Constants.GIPHY_ENTERTAINMENT_MENU_ITEM);
        validation.isTextPresent("Entertainment GIFs");
        clickButtonByXpath(Constants.GIPHY_SPORTS_MENU_ITEM);
        validation.isTextPresent("Sports GIFs");
        clickButtonByXpath(Constants.GIPHY_STICKERS_MENU_ITEM);
        validation.isTextPresent("Stickers");
        clickButtonByXpath(Constants.GIPHY_ARTISTS_MENU_ITEM);
        validation.isTextPresent("GIPHY artists make fun, unique, and original artwork and share it via GIPHY.");
    }

}
