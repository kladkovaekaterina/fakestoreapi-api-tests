package api.api;

import api.models.lombok.UserResponseModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static api.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApi {

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
    public void checkSuccessfulUserApiDeleteResponse
            (String expectedUserId, String expectedFirstname, String expectedLastname,
             String actualUserId, String actualFirstname, String actualLastname) {
        assertEquals(expectedUserId, actualUserId);
        assertEquals(expectedFirstname, actualFirstname);
        assertEquals(expectedLastname, actualLastname);
    }
}