package case_study.furuma.serrvices.employee;

import case_study.furuma.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();
    Page<Employee> findAll(Pageable pageable);
    Employee findById(Integer id);
    void deleteById(Integer id);
    void save(Employee employee);
    Page<Employee> findByName(String name, Pageable pageable);
    Page<Employee> sort(Pageable pageable);
}
