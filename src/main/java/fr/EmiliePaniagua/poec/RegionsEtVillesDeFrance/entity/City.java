package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private int population;
    private String slug;
    private String siren;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy="city")
    private List<PostalCode> postalCodes;
}
