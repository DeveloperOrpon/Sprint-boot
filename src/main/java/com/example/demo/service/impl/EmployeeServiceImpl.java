package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee employeeSave=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employeeSave);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
       Employee employee= employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee Not Found By id :"+id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployees() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.;
    }
}
