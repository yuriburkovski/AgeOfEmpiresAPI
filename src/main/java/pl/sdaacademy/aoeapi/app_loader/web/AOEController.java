package pl.sdaacademy.aoeapi.app_loader.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.aoeapi.app_loader.repository.CivilizationModel;
import pl.sdaacademy.aoeapi.app_loader.service.CivilizationLoaderService;

import java.util.List;

@RequestMapping("/ageofempires")
@RestController
public class AOEController {
    private final CivilizationLoaderService civilizationLoaderService;

    @Autowired
    public AOEController(CivilizationLoaderService civilizationLoaderService) {
        this.civilizationLoaderService = civilizationLoaderService;
    }

    @GetMapping
    public List<CivilizationModel> getCivilizationList() {
        return civilizationLoaderService.getCivilizationList();
    }
}
