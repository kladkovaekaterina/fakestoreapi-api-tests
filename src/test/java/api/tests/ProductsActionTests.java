package api.tests;

import api.api.ProductApi;
import api.config.TestingConfig;
import api.models.lombok.ProductModel;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.data.TestData.newTitle;

@Tag("product")
@Owner("e.kladkova")
@DisplayName("Проверка работы сервера с Product функционалом")
public class ProductsActionTests extends TestBase {

    ProductApi productApi = new ProductApi();
    TestingConfig testingConfig = ConfigFactory.create(TestingConfig.class, System.getProperties());

    @Test
    @DisplayName("Проверка ответа сервера на успешное изменение данных о товаре")
    void successfulApiUpdateProductTest() {
        ProductModel initialData = productApi.makeProductApiGetRequest(testingConfig.productId());
        ProductModel productResponse = productApi.makeProductApiPatchRequest(testingConfig.productId(), newTitle, initialData);
        productApi.checkSuccessfulProductApiPatchResponse(newTitle, testingConfig.productId(), productResponse.getTitle(), productResponse.getId());
        productApi.checkProductTitleHasActuallyChanged(initialData.getTitle(), newTitle);
    }
}