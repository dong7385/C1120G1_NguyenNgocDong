package case_study.furuma.model.employee;

import case_study.furuma.model.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "employee_name", length = 45)
    private String employeeName;
    @Column(name = "employee_birthday", columnDefinition = "date")
    private String employeeBirthday;
    @Column(name="employee_id_card",length = 45)
    private String employeeIdCard;
    @Column(name="employee_salary")
    private double employeeSalary;
    @Column(name="employee_phone",length = 45)
    private String employeePhone;
    @Column(name = "employee_email",length = 45)
    private String employeeEmail;
    @Column(name = "employee_address",length = 45)
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @Column(name = "username",length = 255)
    private String username;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Contract> employeeList;


}
