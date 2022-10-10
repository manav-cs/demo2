package api;
import base.GlobalTestData;
import io.restassured.response.Response;
import org.testng.Assert;
import stepDef.Hook;

public class CarSaverApi extends ApiGeneralFunctions {

    Response response;

    public CarSaverApi() {
    }

    public String postCarSaverSampleToCreateToken() {
        String body = "{\"username\": \"" + GlobalTestData.carSaver_API_user + "\",\"password\": \"" + GlobalTestData.carSaver_API_password + "\"}";
        initializeBaseUri(GlobalTestData.carSaver_API_baseURL);
        response = Hook.request.given().filter(Hook.logFilter)
                .contentType("application/json")
                .body(body)
                .when()
                .post("/rest/endPoint");
        Assert.assertEquals(response.statusCode(), 200);
        printRequest();
        printResponse();
        return response.asPrettyString().replaceAll("\"", "");
    }

    public void postWithToken(String test1, String test2) {
        initializeBaseUri(GlobalTestData.carSaver_API_baseURL);
        String body = "{ \"sourceItems\": [ { \"sku\": \"" + test1 + "\",\"source_code\": \"" + test2 + "\",\"quantity\": 50,\"status\": 1}]}";
        response = Hook.request.given().filter(Hook.logFilter)
                .contentType("application/json")
                .header("Authorization", "Bearer " + postCarSaverSampleToCreateToken())
                .body(body)
                .when()
                .post("/rest/V1/inventory/source-items");
        Assert.assertEquals(response.statusCode(), 200);
        printRequest();
        printResponse();
    }
}
