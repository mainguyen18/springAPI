package com.example.SpringAPI_CRUD.controller;

import com.example.SpringAPI_CRUD.error.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringAPI_CRUD.entity.Employee;
import com.example.SpringAPI_CRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> employees = employeeService.getAllEmployee();
        return employees;
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployees(@PathVariable Long employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId){
        employeeService.deleteById(employeeId);
        return "Delete sussces id " + employeeId;
    }
}
