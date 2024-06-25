package api.tests;

import api.api.UserApi;
import api.config.TestingConfig;
import api.models.lombok.UserResponseModel;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("user")
@Owner("e.kladkova")
@DisplayName("Проверка работы сервера с User функционалом")
public class UserActionTests extends TestBase {

    UserApi userApi = new UserApi();
    TestingConfig testingConfig = ConfigFactory.create(TestingConfig.class, System.getProperties());

    @Test
    @DisplayName("Проверка ответа сервера на успешное удаление пользователя")
    void successfulApiDeleteUserTest() {
        UserResponseModel userResponse = userApi.makeUserApiDeleteRequest(testingConfig.userId());
        userApi.checkSuccessfulUserApiDeleteResponse(userResponse);
    }
}