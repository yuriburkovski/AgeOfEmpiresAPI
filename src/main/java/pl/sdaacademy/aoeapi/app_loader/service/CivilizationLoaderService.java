package pl.sdaacademy.aoeapi.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.sdaacademy.aoeapi.app_loader.repository.AgeOfEmpiresRepository;
import pl.sdaacademy.aoeapi.app_loader.repository.CivilizationModel;
import pl.sdaacademy.aoeapi.app_loader.repository.CivilizationResponse;
import pl.sdaacademy.aoeapi.common.repository.AOERepository;
import pl.sdaacademy.aoeapi.common.repository.Civilization;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CivilizationLoaderService {
    private final AgeOfEmpiresRepository ageOfEmpiresRepository;
    private final AOERepository aoeRepository;
    private final CivilizationTransformer civilizationTransformer;

    @Autowired
    public CivilizationLoaderService(AgeOfEmpiresRepository ageOfEmpiresRepository,
                                     AOERepository aoeRepository,
                                     CivilizationTransformer civilizationTransformer) {
        this.ageOfEmpiresRepository = ageOfEmpiresRepository;
        this.aoeRepository = aoeRepository;
        this.civilizationTransformer = civilizationTransformer;
    }

    @PostConstruct
    @Scheduled(fixedDelayString = "${scheduler.fixed.delay}")
    public List<Civilization> getCivilizationList() {
        CivilizationResponse civilizationResponse;
        List<CivilizationModel> civilizationModels = new ArrayList<>();
        civilizationResponse = ageOfEmpiresRepository.getCivilization();
        civilizationModels.addAll(civilizationResponse.getCivilizations());
        List<Civilization> civilizations = civilizationTransformer.transformToCivilizationList(civilizationModels);
        aoeRepository.saveAll(civilizations);
        return civilizations;
    }
}
