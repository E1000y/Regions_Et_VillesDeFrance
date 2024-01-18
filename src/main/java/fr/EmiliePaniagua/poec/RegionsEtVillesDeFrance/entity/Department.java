package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String slug;

    @ManyToOne
    private Region region;

    @OneToMany(mappedBy="department")
    private List<City> cities;

}
