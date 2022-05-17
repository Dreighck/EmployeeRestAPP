package com.example.employeerestapp.controller;

import com.example.employeerestapp.exception.EmployeeWithTheIDDoesntExistException;
import com.example.employeerestapp.model.Employee;
import com.example.employeerestapp.exception.EmployeeWithTheIDAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.employeerestapp.service.EmployeeService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployee();
        ResponseEntity<List<Employee>> responseEntity;
        responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/employees")
    public ResponseEntity<?> addEmployeeHandler(@RequestBody Employee employee){
        ResponseEntity<?> responseEntity;
        try {
            Employee emp = employeeService.addNewEmployee(employee);
            responseEntity = new ResponseEntity<>(emp, HttpStatus.CREATED);
        }catch (EmployeeWithTheIDAlreadyExistsException e){
            responseEntity = new ResponseEntity<>("Failed to store, Duplicate",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/employees/{empID}")
    public ResponseEntity<?> updateEmployeeHandler(@PathVariable("empID") int id) throws EmployeeWithTheIDDoesntExistException {
        ResponseEntity<?> responseEntity;
        Employee emp = employeeService.getEmployeeById(id);
        responseEntity = new ResponseEntity<>(emp, HttpStatus.OK);

        return responseEntity;
    }


}
