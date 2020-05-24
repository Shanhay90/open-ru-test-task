package ru.guzev.open.test_task.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Company {

    @JsonProperty("company")
    private String companyName;

    @JsonProperty("url")
    private String companyUrl;

    @JsonProperty("text")
    private String companyDescription;
}
