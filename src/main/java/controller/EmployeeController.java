package controller;

import exception.EmployeeWithTheIDAlreadyExistsException;
import exception.EmployeeWithTheIDDoesntExistException;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/demo")
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
