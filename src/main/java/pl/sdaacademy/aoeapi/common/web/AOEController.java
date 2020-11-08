package pl.sdaacademy.aoeapi.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.aoeapi.app_loader.service.CivilizationLoaderService;
import pl.sdaacademy.aoeapi.common.repository.Civilization;
import pl.sdaacademy.aoeapi.details_loader.repository.CivilizationDetails;
import pl.sdaacademy.aoeapi.details_loader.service.DetailsService;

import java.util.List;

@RequestMapping("/ageofempires")
@RestController
public class AOEController {

    private final CivilizationLoaderService civilizationLoaderService;
    private final DetailsService detailsService;

    @Autowired
    public AOEController(CivilizationLoaderService civilizationLoaderService,
                         DetailsService detailsService) {
        this.civilizationLoaderService = civilizationLoaderService;
        this.detailsService = detailsService;
    }

    @GetMapping("/{name}")
    public CivilizationDetails getCivilization(@PathVariable String name) {
        return detailsService.getCivilization(name);
    }

    @GetMapping
    public List<Civilization> getCivilizationList() {
        return civilizationLoaderService.getCivilizationList();
    }
}
