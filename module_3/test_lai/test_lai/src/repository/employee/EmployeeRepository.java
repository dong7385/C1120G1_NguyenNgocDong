package repository.employee;

import model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(int id);
    List<Employee> findAll();
}
