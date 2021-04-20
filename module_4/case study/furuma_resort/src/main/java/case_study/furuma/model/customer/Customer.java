package case_study.furuma.model.customer;

import case_study.furuma.model.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "customer_id")
    private String customerId;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;
    @Column(name = "customer_name", length = 45)
    private String customerName;
    @Column(name = "customer_birthday", columnDefinition = "date")
    private String customerBirthday;
    @Column(name = "customer_gender")
    private Boolean customerGender;
    @Column(name = "customer_id_card", length = 45)
    private String customerIdCard;
    @Column(name = "customer_phone", length = 45)
    private String customerPhone;
    @Column(name = "customer_email", length = 45)
    private String customerEmail;
    @Column(name = "customer_address", length = 45)
    private String customerAddress;

    @OneToMany(mappedBy = "customer")
    private List<Contract>contractList;

}
