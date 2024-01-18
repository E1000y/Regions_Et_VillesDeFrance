package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.PostalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostalCodeRepository extends JpaRepository<PostalCode, Long> {



}

