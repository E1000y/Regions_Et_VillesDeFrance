package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findBySlug(String slug);


    @Query("select c from City c join Department d on c.department = d join Region r on r = d.region where r.slug = ?1 ")
    List<City> getCitiesByRegionSlug(String slug);
}

