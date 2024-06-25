package api.api;

import api.config.TestingConfig;
import api.models.lombok.UserResponseModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;

import static api.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApi {

    TestingConfig testingConfig = ConfigFactory.create(TestingConfig.class, System.getProperties());

    @Step("Выполнить удаление пользователя через API")
    public UserResponseModel makeUserApiDeleteRequest(String userId) {

        return given(requestSpec)

                .when()
                .delete("/users/"+userId)

                .then()
                .spec(responseSpec(ContentType.JSON, 200))
                .extract().as(UserResponseModel.class);
    }

    @Step("Проверить выполнение успешного удаления пользователя через API")
    public void checkSuccessfulUserApiDeleteResponse(UserResponseModel userResponse) {
        assertEquals(testingConfig.userId(), userResponse.getId());
        assertEquals(testingConfig.lastName(), userResponse.getName().getLastname());
    }
}