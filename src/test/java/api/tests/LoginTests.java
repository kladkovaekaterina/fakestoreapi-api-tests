package api.tests;

import io.qameta.allure.Owner;
import api.models.lombok.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import api.api.LoginApi;

import static api.tests.TestData.*;

@Tag("login")
@Owner("e.kladkova")
@DisplayName("Проверка работы сервера c Login функционалом")
public class LoginTests extends TestBase {

    LoginApi loginApi = new LoginApi();

    @Test
    @DisplayName("Проверка ответа сервера на успешную авторизацию пользователя")
    void successfulApiLoginTest() {
        LoginResponseModel loginResponse = loginApi.makeSuccessfulLoginApiPostRequest(userPass);
        loginApi.checkSuccessfulLoginApiResponse(loginResponse.getToken());
    }

    @Test
    @DisplayName("Проверка ответа сервера на неуспешную авторизацию пользователя из-за неверного пароля")
    void wrongPassApiLoginTest() {
        String loginResponse = loginApi.makeLoginApiPostRequest(wrongUserPass);
        loginApi.checkWrongPassLoginApiResponse(loginResponse);
    }
}