package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.service;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.City;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.Department;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository.DepartmentRepository;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {


    private DepartmentRepository   departmentRepository;

    private Slugger slugger;

    public List<Department> findAll(){
        List<Department> departments = departmentRepository.findAll();
        boolean hasFlush = false;
        for (Department department : departments) {
            if (department.getSlug() == null) {
                department.setSlug(slugger.slugify(department.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            departmentRepository.flush();
        }
        return departments;
    }

    public Optional<Department> findBySlug(String string){
        return departmentRepository.findBySlug(string);
    }

}