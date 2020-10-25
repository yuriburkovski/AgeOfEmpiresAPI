package pl.sdaacademy.aoeapi.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.aoeapi.app_loader.repository.AgeOfEmpiresRepository;
import pl.sdaacademy.aoeapi.app_loader.repository.CivilizationModel;
import pl.sdaacademy.aoeapi.app_loader.repository.CivilizationResponse;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CivilizationLoaderService {
    private final AgeOfEmpiresRepository ageOfEmpiresRepository;

    @Autowired
    public CivilizationLoaderService(AgeOfEmpiresRepository ageOfEmpiresRepository) {
        this.ageOfEmpiresRepository = ageOfEmpiresRepository;
    }

    @PostConstruct
    public List<CivilizationModel> getCivilizationList() {
        CivilizationResponse civilizationResponse;
        List<CivilizationModel> civilizationModels = new ArrayList<>();
        civilizationResponse = ageOfEmpiresRepository.getCivilization();
        civilizationModels.addAll(civilizationResponse.getCivilizations());
        return civilizationModels;
    }
}
