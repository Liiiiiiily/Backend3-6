package ru.geekbrains.lesson3;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson3.uploadimg.BaseTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


    //проба пера с Хворостьяновой
    public class AccountTests extends BaseTest {

//хук перед вызовом всех тестов лежит в abstract BaseTest

//тест 1
        @Test
        void getAccountInfoTest() {
            given()
                    // .headers("apiKey", apiKey)
                    .headers(headers)
                    .log()
                    .all()
                    .when()
                    .get("https://spoonacular.com/profile/liiiiiiily/settings")
                    //или
                    //.get("/account/{username}", username)
                    .prettyPeek()
                    .then()
                    .statusCode(200);
        }

        //тест 2
        @Test
        void getAccountInfoWithoutApiKeyTest() {
            when()
                    .get("https://spoonacular.com/profile/liiiiiiily/settings")
                    .prettyPeek()
                    .then()
                    .statusCode(200);
        }

        //тест 3
        @Test
        //тест: проверка, что url принадлежит юзернайму (клиенту)
        void getAccountInfoVerifyUrlTest() {
            String url = given()
                    .headers(headers)
                    .log()
                    .uri()
                    .when()
                    .get("https://spoonacular.com/profile/liiiiiiily/settings")
                    .prettyPeek()
                    .then()
                    .statusCode(200)
                    //проверка заголовка
                    .contentType("application/json")
                    .log()
                    .status()
                    .extract()
                    .response()
                    .jsonPath()
                    .getString("data.url");
            assertThat(url,equalTo("(значение url, т.е. юзернейма = у меня должно быть liiiiiiily)"));
        }

        //тест 4
        @Test
            //тот же тест, но: проверка, что url принадлежит юзернайму (клиенту) ЧЕРЕЗ Given
        void getAccountInfoVerifyUrlInGivenPartTest() {
            given()
                    .headers(headers)
                    .log()
                    .uri()
                    .expect()
                    .body("success",is(true))

                    //is() = equalTo() - чекнуть

                    .body("data.url", is("(значение url, т.е. юзернейма = у меня должно быть liiiiiiily)"))
                    .when()
                    .get("https://spoonacular.com/profile/liiiiiiily/settings")
                    //.prettyPeek()
                    .then()
                    .statusCode(200)
                    //проверка заголовка
                    .contentType("application/json")
                    .log()
                    .status();
        }
        //тест 5


    }
    //конец пробы пера с Хворостьяновой
