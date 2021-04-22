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
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    @Column(name = "service_type_name",length = 45)
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    List<ServiceF> serviceList;
}
