package api.api;

import api.config.LoginConfig;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import api.models.lombok.LoginRequestModel;
import api.models.lombok.LoginResponseModel;
import org.aeonbits.owner.ConfigFactory;

import static api.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginApi {

    LoginConfig loginConfig = ConfigFactory.create(LoginConfig.class, System.getProperties());

    @Step("Выполнить успешную авторизацию через API")
    public LoginResponseModel makeSuccessfulLoginApiPostRequest(String userPass) {
        LoginRequestModel loginRequest = new LoginRequestModel();
        loginRequest.setUsername(loginConfig.userName());
        loginRequest.setPassword(userPass);

        return given(requestSpec)
                .body(loginRequest)

                .when()
                .post("/auth/login")

                .then()
                .spec(responseSpec(ContentType.JSON, 200))
                .extract().as(LoginResponseModel.class);
    }

    @Step("Проверить выполнение успешной авторизации через API")
    public void checkSuccessfulLoginApiResponse(String token) {
        assertThat(token.substring(0,35)).isAlphanumeric();
        assertThat(token.substring(37,95)).isAlphanumeric();
        assertThat(token.substring(97,139)).isNotEmpty();
        assertThat(token).hasSize(140);
    }

    @Step("Выполнить авторизацию через API")
    public String makeLoginApiPostRequest(String userPass) {
        LoginRequestModel loginRequest = new LoginRequestModel();
        loginRequest.setUsername(loginConfig.userName());
        loginRequest.setPassword(userPass);

        return given(requestSpec)
                .body(loginRequest)

                .when()
                .post("/auth/login")

                .then()
                .spec(responseSpec(ContentType.HTML, 401))
                .extract().asString();
    }

    @Step("Проверить выполнение неуспешной авторизации через API из-за неправильного пароля")
    public void checkWrongPassLoginApiResponse(String expectedText) {
        assertEquals("username or password is incorrect", expectedText);
    }
}