package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.restController;


import com.fasterxml.jackson.annotation.JsonView;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.City;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.json_views.JsonViews;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository.CityRepository;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.service.CityService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/city")
public class CityRestController {

    private CityService cityService;

    @GetMapping
    @JsonView(JsonViews.CityListView.class)
    public List<City> list() {
        return this.cityService.findAll();
    }

    @GetMapping("/region/{slug}")
    @JsonView(JsonViews.CityListView.class)
    public List<City> listByRegion(@PathVariable String slug) {
        return this.cityService.findAll(); // ???
    }

    @GetMapping(path = "/{slug}")
    public Optional<City> show(@PathVariable String slug) {
        return cityService.findBySlug(slug);
    }


    @GetMapping(path="region/{slug}/city")
    @JsonView(JsonViews.CityListView.class)
    public List<City> getCitiesByRegionSlug(@PathVariable String slug){ return cityService.findCityByRegionSlug(slug);}

}