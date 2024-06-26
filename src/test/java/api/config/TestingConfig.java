package api.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/testing.properties"
})
public interface TestingConfig extends Config {

    @Key("user.id")
    String userId();

    @Key("last.name")
    String lastName();

    @Key("product.id")
    String productId();
}