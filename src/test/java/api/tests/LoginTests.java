package api.tests;

import api.api.LoginApi;
import api.config.LoginConfig;
import api.models.lombok.LoginResponseModel;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.data.TestData.wrongUserPass;

@Tag("login")
@Owner("e.kladkova")
@DisplayName("Проверка работы сервера c Login функционалом")
public class LoginTests extends TestBase {

    LoginApi loginApi = new LoginApi();
    LoginConfig loginConfig = ConfigFactory.create(LoginConfig.class, System.getProperties());

    @Test
    @DisplayName("Проверка ответа сервера на успешную авторизацию пользователя")
    void successfulApiLoginTest() {
        LoginResponseModel loginResponse = loginApi.makeSuccessfulLoginApiPostRequest(loginConfig.userPass());
        loginApi.checkSuccessfulLoginApiResponse(loginResponse.getToken());
    }

    @Test
    @DisplayName("Проверка ответа сервера на неуспешную авторизацию пользователя из-за неверного пароля")
    void wrongPassApiLoginTest() {
        String loginResponse = loginApi.makeLoginApiPostRequest(wrongUserPass);
        loginApi.checkWrongPassLoginApiResponse(loginResponse);
    }
}