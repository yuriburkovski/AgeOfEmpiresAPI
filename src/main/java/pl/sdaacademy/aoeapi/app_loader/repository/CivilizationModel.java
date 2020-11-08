package pl.sdaacademy.aoeapi.app_loader.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CivilizationModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    private String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/civilization/";

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
