package com.example.managerlibrary.service.Imp;


import com.example.managerlibrary.entity.Employee;
import com.example.managerlibrary.repository.EmployeeRepo;
import com.example.managerlibrary.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
@Autowired
    private EmployeeRepo employeeRepo;
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> emp = employeeRepo.findByEmployeeId(employee.getEmployeeId());
        if (emp.isPresent()) {
            emp.get().setName(employee.getName());
            emp.get().setAge(employee.getAge());
            emp.get().getStartedDate();
            emp.get().setType(employee.getType());
            employeeRepo.save(emp.get());
        }
        return employeeRepo.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepo.findByEmployeeId(id);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);


    }


}
