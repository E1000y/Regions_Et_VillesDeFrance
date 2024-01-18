package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region>  findBySlug(String slug);
}

