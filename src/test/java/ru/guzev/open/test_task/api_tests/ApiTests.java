package ru.guzev.open.test_task.api_tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import ru.guzev.open.test_task.models.Employee;
import ru.guzev.open.test_task.models.UsersPerPageResponse;

import static java.util.Objects.nonNull;
import static ru.guzev.open.test_task.services.ApiService.sendGetRequest;
import static ru.guzev.open.test_task.services.ApiService.sendPostRequest;

public class ApiTests extends ApiBaseTest {

    private final String apiUsersPath = "users";
    private final String perPageRequestPart = "?page=";

    @Test(description = "Получить список пользователей")
    public void firstApiTest() {
        int requestedPageNumber = 2;

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(cfg.apiBaseUrl())
                .setBasePath(apiUsersPath + perPageRequestPart + requestedPageNumber)
                .build();

        UsersPerPageResponse usersPerPageResponse = sendGetRequest(requestSpec, HttpStatus.SC_OK)
                .extract().body()
                .as(UsersPerPageResponse.class);

        Assertions.assertThat(usersPerPageResponse.getUsers())
                .allMatch(user -> nonNull(user.getEmail())
                        && nonNull(user.getFirstName())
                        && nonNull(user.getLastName())
                        && nonNull(user.getAvatarUrl())
                );
    }

    @Test(description = "Создать пользователя")
    public void secondApiTest() {

        Employee user = new Employee();
        user.setName("John Doe");
        user.setJob("Ice cream tester");

        RequestSpecification postRequestSpec = new RequestSpecBuilder()
                .setBaseUri(cfg.apiBaseUrl())
                .setBasePath(apiUsersPath)
                .setBody(user)
                .build();

        Employee createdUser = sendPostRequest(postRequestSpec, HttpStatus.SC_CREATED)
                .extract().response()
                .as(Employee.class);

        Assertions.assertThat(createdUser.getJob())
                .isEqualTo(user.getJob());

        Assertions.assertThat(createdUser.getName())
                .isEqualTo(user.getName());
    }
}
