package case_study.furuma.model.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contact_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_detail_id")
    private Integer contactDetailId;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name ="attach_service_id")
    private AttachService attachService;

    @Column(name = "quantity")
    @Pattern(regexp = "^[\\d]$",message = "The number of floors must be a positive integer")
    private Integer quantity;

}
