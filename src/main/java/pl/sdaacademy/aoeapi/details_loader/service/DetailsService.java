package pl.sdaacademy.aoeapi.details_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.aoeapi.common.repository.AOERepository;
import pl.sdaacademy.aoeapi.common.repository.Civilization;
import pl.sdaacademy.aoeapi.details_loader.repository.CivilizationDetails;
import pl.sdaacademy.aoeapi.details_loader.repository.DetailsRepository;
import pl.sdaacademy.aoeapi.details_loader.repository.api.ApiDetailsRepository;
import pl.sdaacademy.aoeapi.details_loader.repository.api.ApiDetailsResponse;

@Service
public class DetailsService {
    private final AOERepository aoeRepository;
    private final DetailsRepository detailsRepository;
    private final ApiDetailsRepository apiDetailsRepository;
    private final DetailsTransformer detailsTransformer;

    @Autowired
    public DetailsService(AOERepository aoeRepository,
                          DetailsRepository detailsRepository,
                          ApiDetailsRepository apiDetailsRepository,
                          DetailsTransformer detailsTransformer) {
        this.aoeRepository = aoeRepository;
        this.detailsRepository = detailsRepository;
        this.apiDetailsRepository = apiDetailsRepository;
        this.detailsTransformer = detailsTransformer;
    }

    public CivilizationDetails getCivilization(String name) throws NoCivilizationFoundException {
        Civilization civilization = aoeRepository.findByName(name).<NoCivilizationFoundException>orElseThrow(() -> {
            throw new NoCivilizationFoundException(name);
        });
        return provideCivilizationDetails(civilization);
    }

    private CivilizationDetails provideCivilizationDetails(Civilization civilization) {
        return detailsRepository
                .findById(civilization.getId())
                .orElseGet(() -> {
                    CivilizationDetails civilizationDetails = getDetailsFromApi(civilization.getUrl());
                    saveCivilizationDetails(civilizationDetails);
                    return civilizationDetails;
                });
    }

    private void saveCivilizationDetails(CivilizationDetails civilizationDetails) {
        detailsRepository.findById(civilizationDetails.getId())
                .orElseGet(() -> detailsRepository.save(civilizationDetails));
    }

    private CivilizationDetails getDetailsFromApi(String url) {
        ApiDetailsResponse response = apiDetailsRepository.getDetails(url);
        return detailsTransformer.transformToCivilizationDetails(response);
    }
}
