package service.employee;

import model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(int id);
    List<Employee> findAll();
}
