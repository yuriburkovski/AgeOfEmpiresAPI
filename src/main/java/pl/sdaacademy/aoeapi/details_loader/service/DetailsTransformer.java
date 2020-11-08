package pl.sdaacademy.aoeapi.details_loader.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.aoeapi.details_loader.repository.CivilizationDetails;
import pl.sdaacademy.aoeapi.details_loader.repository.api.ApiDetailsResponse;

import java.util.List;

@Component
public class DetailsTransformer {
    public CivilizationDetails transformToCivilizationDetails(ApiDetailsResponse apiDetailsResponse) {
        int id = apiDetailsResponse.getId();
        String name = apiDetailsResponse.getName();
        String expansion = apiDetailsResponse.getExpansion();
        String armyType = apiDetailsResponse.getArmyType();
        List<String> uniqueUnit = apiDetailsResponse.getUniqueUnit();
        List<String> civilizationBonus = apiDetailsResponse.getCivilizationBonus();

        return new CivilizationDetails(id, name, expansion, armyType, uniqueUnit, civilizationBonus);
    }
}
