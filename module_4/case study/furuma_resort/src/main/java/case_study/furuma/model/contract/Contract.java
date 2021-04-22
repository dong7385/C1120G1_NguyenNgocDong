package case_study.furuma.model.contract;

import case_study.furuma.model.customer.Customer;
import case_study.furuma.model.employee.Employee;
import case_study.furuma.model.service.ServiceF;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;
    @Column(name = "contract_start_day",columnDefinition = "datetime")
    private String contractStartDay;
    @Column(name = "contract_end_day",columnDefinition = "datetime")
    private String contractEndDay;
    @Column(name = "contract_deposit")
    private double contractDeposit;
    @Column(name = "contract_total_money")
    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceF serviceF;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    List<ContractDetail> contractDetails;
}
