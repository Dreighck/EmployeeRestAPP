package com.example.employeerestapp.repo;

import com.example.employeerestapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
