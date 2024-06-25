package api.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    // loginData
    public static String wrongUserPass = generateRandomUserPass();

    public static String generateRandomUserPass() {
        return faker.bothify("??????###", false);
    }

    // productData
    public static String newTitle = generateNewTitleForProduct();

    public static String generateNewTitleForProduct() {
        return faker.letterify("????????????", false);
    }
}