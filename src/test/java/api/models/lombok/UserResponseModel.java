package api.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseModel {

    String id;
    Name name;

    @Data
    public static class Name {
        String firstname, lastname;
    }
}