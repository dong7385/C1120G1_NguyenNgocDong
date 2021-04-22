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
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer educationDegreeId;
    @Column(name="education_degree_name",length = 45)
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    List<Employee>employeeList;
}
