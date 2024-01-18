package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.service;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.City;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.Region;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository.CityRepository;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;

    private Slugger slugger;

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public Optional<City> findBySlug(String string){
        return cityRepository.findBySlug(string);
    }

    public List<City> findCityByRegionSlug(String slug){ return cityRepository.getCitiesByRegionSlug(slug);}

}