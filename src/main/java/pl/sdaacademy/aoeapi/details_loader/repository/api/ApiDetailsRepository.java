package pl.sdaacademy.aoeapi.details_loader.repository.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ApiDetailsRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public ApiDetailsRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ApiDetailsResponse getDetails(String urlDetails) {
        return restTemplate.getForObject(urlDetails, ApiDetailsResponse.class);
    }
}
