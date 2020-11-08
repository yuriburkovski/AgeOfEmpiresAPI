package pl.sdaacademy.aoeapi.details_loader.repository.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiDetailsResponse {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("expansion")
    private String expansion;
    @JsonProperty("army_type")
    private String armyType;
    @JsonProperty("unique_unit")
    private List<String> uniqueUnit;
    @JsonProperty("civilization_bonus")
    private List<String> civilizationBonus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getArmyType() {
        return armyType;
    }

    public void setArmyType(String armyType) {
        this.armyType = armyType;
    }

    public List<String> getUniqueUnit() {
        return uniqueUnit;
    }

    public void setUniqueUnit(List<String> uniqueUnit) {
        this.uniqueUnit = uniqueUnit;
    }

    public List<String> getCivilizationBonus() {
        return civilizationBonus;
    }

    public void setCivilizationBonus(List<String> civilizationBonus) {
        this.civilizationBonus = civilizationBonus;
    }
}
