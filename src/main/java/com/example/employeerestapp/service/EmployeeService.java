package com.example.employeerestapp.service;

import com.example.employeerestapp.exception.EmployeeWithTheIDAlreadyExistsException;
import com.example.employeerestapp.exception.EmployeeWithTheIDDoesntExistException;
import com.example.employeerestapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id) throws EmployeeWithTheIDDoesntExistException;
    Employee addNewEmployee(Employee employee) throws EmployeeWithTheIDAlreadyExistsException;
    void deleteEmployee(int id);
    Employee updateEmployee(Employee employee) throws EmployeeWithTheIDAlreadyExistsException, EmployeeWithTheIDDoesntExistException;
}
