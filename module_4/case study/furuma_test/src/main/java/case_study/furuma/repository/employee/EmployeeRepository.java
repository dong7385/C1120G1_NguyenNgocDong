package case_study.furuma.repository.employee;
import case_study.furuma.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> findAllByEmployeeNameContaining(String name ,Pageable pageable);
    Page<Employee> findByOrderByEmployeeName(Pageable pageable);
}
