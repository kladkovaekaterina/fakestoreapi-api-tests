package api.models.lombok;

import lombok.Data;

@Data
public class LoginRequestModel {

    String username, password;
}