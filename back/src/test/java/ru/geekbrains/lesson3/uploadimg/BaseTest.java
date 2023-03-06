package ru.geekbrains.lesson3.uploadimg;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class BaseTest {
    //Map - удобнее всего в rest-assured
    protected static Properties prop = new Properties();
    protected static String apiKey;
    protected static String username;
    protected static Map<String, String> headers = new HashMap<>();

    @BeforeAll
    static void beforeAll() {
        loadProperties();
        apiKey = prop.getProperty("apiKey");
        headers.put("apiKey", apiKey);

        RestAssured.baseURI= prop.getProperty("base.url");
        username = prop.getProperty("username");
        // RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    private static void loadProperties() {
        try {
            prop.load(new FileInputStream("src/test/java/resources/my.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
