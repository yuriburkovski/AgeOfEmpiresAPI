package pl.sdaacademy.aoeapi.app_loader.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CivilizationModel {
    @JsonProperty("name")
    private String name;
    @JsonProperty("unique_unit")
    private List<String> uniqueUnit;

    public String getName() {
        return name;
    }

    public List<String> getUniqueUnit() {
        return uniqueUnit;
    }
}
