package siteforge;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class BootstrapTest {
    @Test
    void startsWithoutExposingUnimplementedStudioRoutes() {
        given()
            .when().get("/api/v1/projects")
            .then().statusCode(404);
    }
}
