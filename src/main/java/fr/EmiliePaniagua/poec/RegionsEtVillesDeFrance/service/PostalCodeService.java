package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.service;

import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity.PostalCode;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.repository.PostalCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostalCodeService {

    private PostalCodeRepository postalCodeRepository;

    public List<PostalCode> findAll(){
        return postalCodeRepository.findAll();
    }

}