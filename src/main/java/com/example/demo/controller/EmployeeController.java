package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController

@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    /// Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
       EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //build employee by id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long eId){
       EmployeeDto employeeDto= employeeService.getEmployeeById(eId);
       return  ResponseEntity.ok(employeeDto);
    }
}
