package service;

import exception.EmployeeWithTheIDAlreadyExistsException;
import exception.EmployeeWithTheIDDoesntExistException;
import model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id);
    Employee addNewEmployee(Employee employee) throws EmployeeWithTheIDAlreadyExistsException;
    void deleteEmployee(int id);
    Employee updateEmployee(Employee employee) throws EmployeeWithTheIDAlreadyExistsException, EmployeeWithTheIDDoesntExistException;
}
