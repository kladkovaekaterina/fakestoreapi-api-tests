package api.tests;

import api.api.UserApi;
import api.models.lombok.UserResponseModel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.tests.TestData.*;

@Tag("user")
@Owner("e.kladkova")
@DisplayName("Проверка работы сервера с User функционалом")
public class UserActionTests extends TestBase {

    UserApi userApi = new UserApi();

    @Test
    @DisplayName("Проверка ответа сервера на успешное удаление пользователя")
    void successfulApiDeleteUserTest() {
        UserResponseModel userResponse = userApi.makeUserApiDeleteRequest(userId);
        userApi.checkSuccessfulUserApiDeleteResponse(userId, firstName, lastName, userResponse.getId(), userResponse.getName().getFirstname(), userResponse.getName().getLastname());
    }
}