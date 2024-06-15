package api.tests;

import api.api.ProductApi;
import api.models.lombok.ProductModel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.tests.TestData.*;

@Tag("product")
@Owner("e.kladkova")
@DisplayName("Проверка работы сервера с Product функционалом")
public class ProductsActionTests extends TestBase {

    ProductApi productApi = new ProductApi();

    @Test
    @DisplayName("Проверка ответа сервера на успешное изменение данных о товаре")
    void successfulApiUpdateProductTest() {
        ProductModel initialData = productApi.makeProductApiGetRequest(productId);
        ProductModel productResponse = productApi.makeProductApiPatchRequest(productId, newTitle, initialData);
        productApi.checkSuccessfulProductApiPatchResponse(newTitle, productId, productResponse.getTitle(), productResponse.getId());
        productApi.checkProductTitleHasActuallyChanged(initialData.getTitle(), newTitle);
    }
}