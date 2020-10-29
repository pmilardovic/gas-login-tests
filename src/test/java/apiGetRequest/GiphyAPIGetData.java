package apiGetRequest;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class GiphyAPIGetData {

    /**
     * Entering valid parameters and validating response code.
     */
    @Test
    public void P_Search_ValidateResponseCode() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, Constants.validSearchRequest);
        int statusCode = response.getStatusCode();
        response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    /**
     * Entering valid parameters and validating response headers.
     */
    @Test
    public void P_Search_ValidateRequestHeaders() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, Constants.validSearchRequest);
        Headers body = response.getHeaders();
        System.out.println("Headers:" + body);

        String contentType = response.header("Content-type");
        System.out.println("Content type is: " + contentType);
        Assert.assertEquals(contentType, "application/json");

        String contentEncoding = response.header("Content-Encoding");
        System.out.println("Content Encoding type is: " + contentEncoding);
    }

    /**
     * Entering invalid api key parameter and validating response body.
     */
    @Test
    public void N_InvalidApiKey_ValidateResponseBody() {
        String dummyAPIKey = "api_key=pm2210";

        String invalidAPIUrl = Constants.GIPHY_BASE_URL + Constants.GIPY_ENDPOINT_SEARCH + dummyAPIKey;
        String body = get(invalidAPIUrl).asString();
        System.out.println("Body is " + body);
        get(invalidAPIUrl).then().assertThat().body("message", Is.is(Constants.GIPHY_INVALID_CREDENTIALS_ERROR));
    }

    /**
     * Entering invalid q parameter(non existing gif name) and validating response body.
     */
    @Test
    public void N_SearchNonExistingGif_ValidateResponseBody() {
        String nonExistingParamQ = "pm2210";
        String invalidSearchRequest = Constants.GIPHY_BASE_URL + Constants.GIPY_ENDPOINT_SEARCH
                + Constants.GIPHY_API_KEY + "&" + nonExistingParamQ;

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, invalidSearchRequest);
        response.then()
                .assertThat()
                .body("data", Matchers.hasSize(0))
                .body("pagination.count", Is.is(0))
                .body("meta.status", Is.is(200))
                .body("meta.msg", Is.is("OK"));
    }

    /**
     * Request GIF by valid ID and validate response body.
     */
    @Test
    public void P_GetGIFByID_ValidateResponseBody() {
        String gifID = "ikwPoLi821cIg?";
        String getGIFByIDRequest = Constants.GIPHY_BASE_URL + gifID + Constants.GIPHY_API_KEY;

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, getGIFByIDRequest);
        response.then()
                .assertThat()
                .body("data.id", Is.is("ikwPoLi821cIg"))
                .body("data.title", Is.is("oscars leo GIF"))
                .body("meta.status", Is.is(200))
                .body("meta.msg", Is.is("OK"));
    }

    /**
     * Request GIF by invalid ID and validate response body.
     */
    @Test
    public void P_GetGIFByInvalidID_ValidateResponseBody() {
        String gifID = "pm2210?";
        String getGIFByIDRequest = Constants.GIPHY_BASE_URL + gifID + Constants.GIPHY_API_KEY;

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, getGIFByIDRequest);
        response.then()
                .assertThat()
                .body("data", Matchers.hasSize(0))
                .body("meta.status", Is.is(404))
                .body("meta.msg", Is.is("Not Found"));
    }


    /**
     * Request List of GIF categories
     */
    @Test
    public void P_GetGifCategories_ValidateResponseBody() {
        String getGIFCategoriesRequest = Constants.GIPHY_BASE_URL + Constants.GIPHY_ENDPOINT_CATEG + Constants.GIPHY_API_KEY;

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, getGIFCategoriesRequest);
        response.then()
                .assertThat()
                .body("pagination.total_count", Is.is(28))
                .body("meta.status", Is.is(200))
                .body("meta.msg", Is.is("OK"));
    }
}