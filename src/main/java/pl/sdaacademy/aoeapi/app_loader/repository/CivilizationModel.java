package pl.sdaacademy.aoeapi.app_loader.repository;

import java.util.List;

public class CivilizationModel {
    private String name;
    private List<String> uniqueUnit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUniqueUnit() {
        return uniqueUnit;
    }

    public void setUniqueUnit(List<String> uniqueUnit) {
        this.uniqueUnit = uniqueUnit;
    }
}
