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

public class Region{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    private String code;
    private String slug;

    @OneToMany(mappedBy = "region")
    private List<Department> departments;

}
