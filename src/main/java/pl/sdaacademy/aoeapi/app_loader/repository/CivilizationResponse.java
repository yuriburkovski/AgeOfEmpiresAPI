package pl.sdaacademy.aoeapi.app_loader.repository;

import java.util.List;

public class CivilizationResponse {
    private List<CivilizationModel> civilizations;

    public List<CivilizationModel> getCivilizations() {
        return civilizations;
    }

    public void setCivilizations(List<CivilizationModel> civilizations) {
        this.civilizations = civilizations;
    }
}
