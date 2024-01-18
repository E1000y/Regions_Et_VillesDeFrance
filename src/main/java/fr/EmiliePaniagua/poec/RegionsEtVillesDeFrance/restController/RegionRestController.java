package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.restController;


import com.fasterxml.jackson.annotation.JsonView;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.Region;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.json_views.JsonViews;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/region")
public class RegionRestController {

    private RegionService regionService;

    @GetMapping
    @JsonView(JsonViews.RegionListView.class)
    public List<Region> list() {
        return this.regionService.findAll();
    }

    @GetMapping(path = "/{field}")
    @JsonView(JsonViews.RegionShowView.class)
    public Optional<Region> show(@PathVariable String field) {
            return this.regionService.findBySlug(field);
    }

}