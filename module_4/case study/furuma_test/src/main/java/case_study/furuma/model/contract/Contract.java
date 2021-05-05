package case_study.furuma.model.contract;

import case_study.furuma.model.customer.Customer;
import case_study.furuma.model.employee.Employee;
import case_study.furuma.model.service.ServiceF;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "contract")
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;
    @Column(name = "contract_start_day", columnDefinition = "datetime")
    private String contractStartDay;
    @Column(name = "contract_end_day", columnDefinition = "datetime")
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

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    List<ContractDetail> contractDetails;


    /**
     * Can this {@link Validator} {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code clazz}?
     * <p>This method is <i>typically</i> implemented like so:
     * <pre class="code">return Foo.class.isAssignableFrom(clazz);</pre>
     * (Where {@code Foo} is the class (or superclass) of the actual
     * object instance that is to be {@link #validate(Object, Errors) validated}.)
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed
     * {@link #validate(Object, Errors) validate} instances of the
     * supplied {@code clazz}
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        Contract contract = (Contract) object;
        try {
            System.out.println(contract.getContractStartDay());
            Date start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(contract.contractStartDay);
            Date end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(contract.contractEndDay);
//            Date currentDate = new Date();
//            if (start.after(end)) {
//                errors.rejectValue("contractStartDay", "start.afterEnd");
//            }

            if (end.before(start)) {
                errors.rejectValue("contractEndDay", "end.beforeStart");
            }
//            if (end.before(currentDate)){
//                errors.rejectValue("contractEndDay", "end.beforeCurrent");
//            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
