package wishlist;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTestWithWishList {
    DataWishList dataWishList = new DataWishList();

    @Test
    public void addToWishListTest() {
        Response response =
                given()
                        .body(dataWishList.getBody())
                        .contentType(dataWishList.getContent_type())
                        .when()
                        .post(dataWishList.getUrlWishList())
                        .then()
                        .statusCode(200)
                        .extract().response();

        Assertions.assertTrue(response.asString().contains("The product has been added"));


    }

}
