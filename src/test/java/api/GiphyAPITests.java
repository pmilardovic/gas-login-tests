package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GiphyAPITests {

    /**
     * Sending valid API request and validating response code.
     */
    @Test
    public void P_Search_ValidateResponseCode() {
        RestAssured.
                when().
                get(Constants.validSearchRequest).
                then().
                assertThat().
                statusCode(200);
    }

    /**
     * Sending valid API request and validating response headers.
     */
    @Test
    public void P_Search_ValidateRequestHeaders() {
        Response response = RestAssured.get(Constants.validSearchRequest);

        String contentType = response.getHeader("content-type");
        System.out.println("Content type is: " + contentType);
        Assert.assertEquals(contentType, "application/json");

        String contentEncoding = response.getHeader("content-Encoding");
        System.out.println("Content Encoding type is: " + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

        String cacheControl = response.getHeader("cache-control");
        System.out.println("Cache-control is: " + cacheControl);
        Assert.assertEquals(cacheControl, "max-age=30");

    }

    /**
     * Sending invalid api key parameter and validating response body.
     */
    @Test
    public void N_InvalidApiKey_ValidateResponseBody() {
        String dummyAPIKey = "api_key=pm2210";
        RestAssured.
                when().
                get(Constants.GIPHY_BASE_URL + Constants.GIPY_ENDPOINT_SEARCH + "?" + dummyAPIKey).
                then().
                assertThat().
                body("message", Is.is("Invalid authentication credentials"));

        //String body = RestAssured.get(functional.Constants.GIPHY_BASE_URL + functional.Constants.GIPY_ENDPOINT_SEARCH + "?" + dummyAPIKey).asString();
        //System.out.println("Body is " + body);
    }

    /**
     * Sending invalid q parameter(non existing gif name) and validating response body.
     */
    @Test
    public void N_SearchNonExistingGif_ValidateResponseBody() {
        String nonExistingParamQ = "pm2210";
        RestAssured.
                when().
                get(Constants.GIPHY_BASE_URL + Constants.GIPY_ENDPOINT_SEARCH + "?"
                        + Constants.GIPHY_API_KEY + "&" + nonExistingParamQ).
                then()
                .assertThat()
                .body("data", Matchers.hasSize(0))
                .body("pagination.count", Is.is(0))
                .body("meta.status", Is.is(200))
                .body("meta.msg", Is.is("OK"));

        //String body = RestAssured.get(functional.Constants.GIPHY_BASE_URL + functional.Constants.GIPY_ENDPOINT_SEARCH + "?"
        // + functional.Constants.GIPHY_API_KEY + "&" + nonExistingParamQ).asString();
        //System.out.println("Body is " + body);
    }

    /**
     * Sending valid GIF ID and validate response body.
     */
    @Test
    public void P_GetGIFByID_ValidateResponseBody() {
        String gifID = "sp685iuIEGuys";
        RestAssured.given().
                when().
                get(Constants.GIPHY_BASE_URL + gifID + "?" + Constants.GIPHY_API_KEY).
                then()
                .assertThat()
                .body("data.id", Is.is("sp685iuIEGuys"))
                .body("data.title", Is.is("gatsby GIF"))
                .body("meta.status", Is.is(200))
                .body("meta.msg", Is.is("OK"));

        //String body = get(functional.Constants.GIPHY_BASE_URL + gifID + "?" + functional.Constants.GIPHY_API_KEY).
        //System.out.println("Body is " + body);

    }

    /**
     * Sending invalid GIF ID and validate response body.
     */
    @Test
    public void P_GetGIFByInvalidID_ValidateResponseBody() {
        String gifID = "somerandomID";
        RestAssured.given().
                when().
                get(Constants.GIPHY_BASE_URL + gifID + "?" + Constants.GIPHY_API_KEY).
                then()
                .assertThat()
                .body("data", Matchers.hasSize(0))
                .body("meta.status", Is.is(404))
                .body("meta.msg", Is.is("Not Found"));

        //String body = get(functional.Constants.GIPHY_BASE_URL + gifID + "?" + functional.Constants.GIPHY_API_KEY).
        //System.out.println("Body is " + body);
    }


    /**
     * Sending valid request for list of GIF categories and validating response body.
     */
    @Test
    public void P_GetGifCategories_ValidateResponseBody() {
        RestAssured.given().
                when().
                get(Constants.GIPHY_BASE_URL + Constants.GIPHY_ENDPOINT_CATEG + "?" + Constants.GIPHY_API_KEY).
                then()
                .assertThat()
                .body("pagination.total_count", Is.is(28))
                .body("meta.status", Is.is(200))
                .body("meta.msg", Is.is("OK"));
    }
}