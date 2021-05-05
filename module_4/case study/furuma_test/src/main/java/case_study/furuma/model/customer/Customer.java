package case_study.furuma.model.customer;

import case_study.furuma.model.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "customer_id")
    @Pattern(regexp = "^KH-\\d{4}$",message = "Customer Code is form KH-XXXX (X is number from 0-9)")
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
    @Pattern(regexp = "^\\d{9}|\\d{12}",message = "ID number must be in the format XXXXXXXXX or XXXXXXXXXXXX")
    private String customerIdCard;
    @Column(name = "customer_phone", length = 45)
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$", message = "Phone number is not valid")
    private String customerPhone;
    @Column(name = "customer_email", length = 45)
    @Email(message = "Email is not valid")
    private String customerEmail;
    @Column(name = "customer_address", length = 45)
    private String customerAddress;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract>contractList;

}
