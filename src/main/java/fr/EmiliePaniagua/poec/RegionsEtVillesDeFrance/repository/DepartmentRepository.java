package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {



    Optional<Department> findBySlug(String slug);
}

