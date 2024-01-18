package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.restController;


import com.fasterxml.jackson.annotation.JsonView;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.Department;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.json_views.JsonViews;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository.DepartmentRepository;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/department")
public class DepartmentRestController {

    private DepartmentService departmentService;

    @GetMapping
    @JsonView(JsonViews.DepartmentListView.class)
    public List<Department> list() {
        return this.departmentService.findAll();
    }

    @GetMapping(path = "/{field}")
    @JsonView(JsonViews.DepartmentShowView.class)
    public Optional<Department> show(@PathVariable String field) {
        return  departmentService.findBySlug(field);
    }

}