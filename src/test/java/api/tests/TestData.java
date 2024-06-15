package api.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));

    // loginData
    public static String userName = "mor_2314",
                         userPass = "83r5^_",
                         wrongUserPass = generateRandomUserPass();

    public static String generateRandomUserPass() {
        return faker.bothify("??????###", false);
    }

    // userData
    public static String userId = "6",
                         firstName = "david",
                         lastName = "russell";

    // productData
    public static String productId = "7",
                         newTitle = generateNewTitleForProduct();

    public static String generateNewTitleForProduct() {
        return faker.letterify("????????????", false);
    }
}