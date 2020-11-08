package pl.sdaacademy.aoeapi.app_loader.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AgeOfEmpiresRepository {
    private final String url;
    private final RestTemplate restTemplate;

    @Autowired
    public AgeOfEmpiresRepository(@Value("https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations") String url,
                                  RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public CivilizationResponse getCivilization() {
        return restTemplate.getForObject(url, CivilizationResponse.class);
    }

}
