package service;

import exception.EmployeeWithTheIDAlreadyExistsException;
import exception.EmployeeWithTheIDDoesntExistException;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) throws EmployeeWithTheIDDoesntExistException {
        Optional<Employee> optional = employeeRepo.findById(id);
        if (optional.isPresent())
            return employeeRepo.getById(id);
        throw new EmployeeWithTheIDDoesntExistException();
    }

    @Override
    public Employee addNewEmployee(Employee employee) throws EmployeeWithTheIDAlreadyExistsException {
        Optional<Employee> optional = employeeRepo.findById(employee.getId());
        if (optional.isEmpty()){
            employeeRepo.save(employee);
            return employee;
        }
        throw new EmployeeWithTheIDAlreadyExistsException();
    }

    @Override
    public void deleteEmployee(int id) {
        List<Employee> employees = getAllEmployee();
        employees = employees.stream().filter(
                (e)->
                        e.getId()!= id)
                .collect(Collectors.toList());
    }

    @Override
    public Employee updateEmployee(Employee employee) throws EmployeeWithTheIDDoesntExistException {
        Optional<Employee> optional = employeeRepo.findById(employee.getId());
        if (optional.isPresent()){
            employeeRepo.save(employee);
            return employee;
        }
        throw new EmployeeWithTheIDDoesntExistException();


    }
}
