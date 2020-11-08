package pl.sdaacademy.aoeapi.details_loader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<CivilizationDetails, Integer> {
    CivilizationDetails save(CivilizationDetails civilizationDetails);
}
