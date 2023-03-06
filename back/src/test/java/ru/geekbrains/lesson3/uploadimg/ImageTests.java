package ru.geekbrains.lesson3.uploadimg;

import io.restassured.mapper.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ImageTests extends BaseTest{

    String encodedImage;

    @BeforeEach
    void setUp() {
        byte[] fileContent = getFileContentInBase64();
        encodedImage = Base64.getEncoder().encodeToString(fileContent);
    }

    @Test
    void uploadFileTest() {
        String uploadImageHashCode = given()
                .headers("apiKey", apiKey)
                .multiPart("image", "encodedImage")
                .body("success", (ObjectMapper) is(true))
                .body("success", (ObjectMapper) is(notNullValue()))
                //нужен path, а у меня object :(
                .when()
                .post("/image")
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @AfterEach
    void tearDown() {
        given()
                .headers("apiKey", apiKey)
                .when()
                .delete("account/{username}/image/{deletehash}")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    private byte[] getFileContentInBase64() {
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(classLoader.getResource("image.jpg").getFile());
        byte[] fileContent =new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
