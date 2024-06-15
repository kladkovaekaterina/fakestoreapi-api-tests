package api.api;

import api.models.lombok.ProductModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static api.specs.Specs.requestSpec;
import static api.specs.Specs.responseSpec;
import static api.tests.TestData.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductApi {

    @Step("Посмотреть данные товара через API")
    public ProductModel makeProductApiGetRequest(String productId) {

        return given(requestSpec)

                .when()
                .get("/products/"+productId)

                .then()
                .spec(responseSpec(ContentType.JSON, 200))
                .extract().as(ProductModel.class);
    }

    @Step("Выполнить изменение данных товара через API")
    public ProductModel makeProductApiPatchRequest(String productId, String newTitle, ProductModel oldData) {
        ProductModel productRequest = new ProductModel();
        productRequest.setTitle(newTitle);
        productRequest.setPrice(oldData.getPrice());
        productRequest.setDescription(oldData.getDescription());
        productRequest.setImage(oldData.getImage());
        productRequest.setCategory(oldData.getCategory());

        return given(requestSpec)
                .body(productRequest)

                .when()
                .patch("/products/"+productId)

                .then()
                .spec(responseSpec(ContentType.JSON, 200))
                .extract().as(ProductModel.class);
    }

    @Step("Проверить выполнение успешного изменения данных товара через API")
    public void checkSuccessfulProductApiPatchResponse(String expectedTitle, String expectedId, String actualTitle, String actualId) {
        assertEquals(expectedTitle, actualTitle);
        assertEquals(expectedId, actualId);
    }

    @Step("Проверить, что данные товара изменены")
    public void checkProductTitleHasActuallyChanged(String oldTitle, String newTitle) {
        assertNotEquals(oldTitle, newTitle);
    }
}