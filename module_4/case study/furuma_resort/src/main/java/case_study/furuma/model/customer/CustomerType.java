package case_study.furuma.model.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
@NoArgsConstructor
@Getter
@Setter
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer customerTypeId;
    @Column(name = "customer_type_name", length = 45)
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private List<Customer> customerList;
}
