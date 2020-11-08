package pl.sdaacademy.aoeapi.app_loader.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.aoeapi.app_loader.repository.CivilizationModel;
import pl.sdaacademy.aoeapi.common.repository.Civilization;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CivilizationTransformer {

    public Civilization transformToCivilization(CivilizationModel civilizationModel) {
        String url = civilizationModel.getUrl() + civilizationModel.getId();
        return new Civilization(civilizationModel.getId(), civilizationModel.getName(), url);
    }

    public List<Civilization> transformToCivilizationList(List<CivilizationModel> civilizationModels) {
        return civilizationModels.stream()
                .filter(Objects::nonNull)
                .map(this::transformToCivilization)
                .collect(Collectors.toList());
    }
}
