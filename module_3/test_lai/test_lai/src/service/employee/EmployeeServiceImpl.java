package service.employee;

import model.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository=new EmployeeRepositoryImpl();

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
