package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.service;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.Region;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository.RegionRepository;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService {

    private RegionRepository regionRepository;

    private Slugger slugger;

    public List<Region> findAll() {
        List<Region> regions = regionRepository.findAll();
        boolean hasFlush = false;
        for (Region region : regions) {
            if (region.getSlug() == null) {
                region.setSlug(slugger.slugify(region.getName()));
                hasFlush = true;
            }
        }
        if (hasFlush) {
            regionRepository.flush();
        }
        return regions;
    }

    public Optional<Region> findBySlug(String string){
        return regionRepository.findBySlug(string);
    }

}