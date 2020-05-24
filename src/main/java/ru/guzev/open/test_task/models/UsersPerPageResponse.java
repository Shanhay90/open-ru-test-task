package ru.guzev.open.test_task.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UsersPerPageResponse {

    @JsonProperty("page")
    private int pageNumber;

    @JsonProperty("per_page")
    private int usersPerPage;

    @JsonProperty("total")
    private int totalNumberOfUsers;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("data")
    private List<User> users;

    @JsonProperty("ad")
    private Company company;
}
