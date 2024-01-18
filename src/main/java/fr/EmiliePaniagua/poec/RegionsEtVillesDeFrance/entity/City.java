package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.json_views.JsonViews;
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
    @JsonView(JsonViews.CityListView.class)
    private Integer id;

    @JsonView({JsonViews.CityListView.class,JsonViews.DepartmentShowView.class})
    private String name;

    private String code;

    private int population;

    @JsonView({JsonViews.CityListView.class, JsonViews.DepartmentShowView.class})
    private String slug;

    private String siren;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy="city")
    private List<PostalCode> postalCodes;
}
