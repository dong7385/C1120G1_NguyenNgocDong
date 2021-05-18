package case_study.furuma.model.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Integer divisionId;
    @Column(name = "division_name", nullable = false)
    private String divisionName;
    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    List<Employee> employeeList;
}
