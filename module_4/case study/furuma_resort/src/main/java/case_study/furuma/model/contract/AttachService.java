package case_study.furuma.model.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer attachServiceId;
    @Column(name = "attach_service_name",length = 45)
    private String attachServiceName;
    @Column(name = "attach_service_cost",length = 45)
    private String attachServiceCost;
    @Column(name = "attach_service_unit")
    private Integer attachServiceUnit;
    @Column(name = "attach_service_status",length = 45)
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    List<ContractDetail>contractDetails;
}
