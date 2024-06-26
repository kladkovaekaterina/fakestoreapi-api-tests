package api.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/login.properties"
})
public interface LoginConfig extends Config {

    @Key("login.username")
    String userName();

    @Key("login.userpass")
    String userPass();
}