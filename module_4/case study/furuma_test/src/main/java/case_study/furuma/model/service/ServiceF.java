package case_study.furuma.model.service;

import case_study.furuma.model.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "service")
public class ServiceF {
    @Id
    @Column(name = "service_id", length = 45)
   @Pattern(regexp = "^DV-\\d{4}$",message = "Service Code format is DV-XXXX (X is number 0-9)")
    private String serviceId;
    @Column(name = "service_name", length = 45)
    private String serviceName;
    @Column(name = "service_area")
    private Integer serviceArea;
    @Column(name = "service_cost")
    private double serviceCost;
    @Column(name = "service_max_people")
    private Integer serviceMaxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;
    @Column(name = "standard_room", length = 45)
    private String standardRoom;
    @Column(name = "description_other_convenience", length = 45)
    private String descriptionOtherConvenience;
    @Column(name = "pool_area")
    private double poolArea;
    @Column(name = "number_of_floors")
    @Pattern(regexp = "^[\\d]$",message = "The number of floors must be a positive integer")
    private Integer numberOfFloors;

    @OneToMany(mappedBy = "serviceF",cascade = CascadeType.ALL)
    private List<Contract> contractList;
}
