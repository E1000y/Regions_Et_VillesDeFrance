package fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.entity;


import com.fasterxml.jackson.annotation.JsonView;
import fr.EmiliePaniagua.poec.RegionsEtVillesDeFrance.json_views.JsonViews;
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
    @JsonView(JsonViews.DepartmentListView.class)
    private Integer id;

    @JsonView({JsonViews.DepartmentListView.class, JsonViews.RegionShowView.class})
    private String name;

    @JsonView({JsonViews.DepartmentListView.class, JsonViews.RegionShowView.class})
    private String code;

    @JsonView({JsonViews.DepartmentListView.class, JsonViews.RegionShowView.class})
    private String slug;

    @ManyToOne
    @JsonView(JsonViews.DepartmentShowView.class)
    private Region region;

    @OneToMany(mappedBy="department")
    @JsonView(JsonViews.DepartmentShowView.class)
    private List<City> cities;

}
