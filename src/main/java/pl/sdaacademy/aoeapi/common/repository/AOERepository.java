package pl.sdaacademy.aoeapi.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AOERepository extends JpaRepository<Civilization, Integer> {

    Optional<Civilization> findByName(String name);
}
