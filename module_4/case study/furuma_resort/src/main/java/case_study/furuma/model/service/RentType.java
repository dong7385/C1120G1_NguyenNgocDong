package case_study.furuma.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;
    @Column(name = "rent_type_name",length = 45)
    private String rentTypeName;
    @Column(name = "rent_type_cost")
    private double rentTypeCode;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    private List<ServiceF>serviceList;
}
