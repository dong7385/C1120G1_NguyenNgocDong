package case_study.furuma.serrvices.employee.impl;

import case_study.furuma.model.employee.Employee;
import case_study.furuma.repository.employee.EmployeeRepository;
import case_study.furuma.serrvices.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(name, pageable);
    }

    @Override
    public Page<Employee> sort(Pageable pageable) {
        return employeeRepository.findByOrderByEmployeeName(pageable);
    }
}
