package com.xadmin.dto.controller;

import com.xadmin.dto.Dto.EmployeeDto;
import com.xadmin.dto.convert.EmployeeConverter;
import com.xadmin.dto.model.Employee;
import com.xadmin.dto.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeConverter employeeConverter;


    @GetMapping("/find")
    public List<EmployeeDto>findAll(){
        List<Employee> employee=employeeRepository.findAll();
        return employeeConverter.entityToDto(employee);
    }

    @GetMapping("/")
    public EmployeeDto findById(@PathVariable("id") Long id){
        Employee employee=employeeRepository.findById(id).orElse(null);
        return employeeConverter.entityToDto(employee);
    }

    @PostMapping("/")
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        Employee employee=employeeConverter.dtoToEntity(employeeDto);
              employee=employeeRepository.save(employee);
        return employeeConverter.entityToDto(employee);
    }

}
