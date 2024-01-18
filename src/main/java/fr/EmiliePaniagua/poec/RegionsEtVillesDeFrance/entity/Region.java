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

public class Region{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.RegionListView.class)
    private Integer id;

    @JsonView({JsonViews.RegionListView.class, JsonViews.DepartmentShowView.class})
    private String name;

    @JsonView(JsonViews.RegionListView.class)
    private String code;

    @JsonView({JsonViews.RegionListView.class, JsonViews.DepartmentShowView.class})
    private String slug;

    @OneToMany(mappedBy = "region")
    @JsonView(JsonViews.RegionShowView.class)
    private List<Department> departments;

}
