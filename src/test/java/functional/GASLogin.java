package functional;

import org.testng.annotations.Test;


public class GASLogin extends FrontendActions {

    public void loginUser() {
        navigateToPage(Constants.GAS_MFA_PAGE);
        sleep(5);
        clickElementByXpath(Constants.GAS_COUNTRY_LANGUAGE_POPUP_BUTTON);
        sleep(5);
        clickElementById(Constants.GAS_LOGIN_MANAGERS_TILE);
        fillInputFieldBySendKeys(Constants.GAS_LOGIN_USERNAME, "CORPPRI2\\span-pmisic");
        fillInputFieldBySendKeys(Constants.GAS_LOGIN_PASSWORD, "abc123!#");
        clickElementByXpath(Constants.GAS_LOGIN_BUTTON);
    }

    @Test
    public void P_Login_ValidUser() {
        //Precondition: user registered for TOTP
        loginUser();
        validation.isTextPresent("MFA Authentication");
    }

    @Test
    public void P_Login_invalidUser() {
        navigateToPage(Constants.GAS_MFA_PAGE);
        sleep(5);
        clickElementByXpath(Constants.GAS_COUNTRY_LANGUAGE_POPUP_BUTTON);
        sleep(5);
        clickElementById(Constants.GAS_LOGIN_MANAGERS_TILE);
        fillInputFieldBySendKeys(Constants.GAS_LOGIN_USERNAME, helper.randomStringGenerator());
        fillInputFieldBySendKeys(Constants.GAS_LOGIN_PASSWORD, helper.randomStringGenerator());
        clickElementByXpath(Constants.GAS_LOGIN_BUTTON);
        sleep(5);
        validation.elementTextIsEqualById(Constants.GAS_INVALID_LOGIN_ERROR_ID, Constants.GAS_INVALID_LOGIN_ERROR_MSG);
    }

    @Test
    public void P_TOTPValidation_invalidCodeFormat() {
        loginUser();
        validation.isTextPresent("MFA Authentication");
        sleep(5);
        fillInputFieldBySendKeys(Constants.GAS_TOTP_CODE_FIELD, helper.randomNumberGenerator());
        validation.isTextPresent(Constants.GAS_TOTP_INVALID_CODE_FORMAT);
    }

    @Test
    public void P_TOTPValidation_invalidCode() {
        loginUser();
        validation.isTextPresent("MFA Authentication");
        sleep(5);
        fillInputFieldBySendKeys(Constants.GAS_TOTP_CODE_FIELD, "123456");
        validation.isTextPresent(Constants.GAS_TOTP_INVALID_CODE);
    }
}
