package com.xadmin.dto.convert;

import com.xadmin.dto.Dto.EmployeeDto;
import com.xadmin.dto.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConverter {

    public EmployeeDto entityToDto(Employee employee){
        EmployeeDto dto=new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setDepartment(dto.getDepartment());
        return dto;

    }
    public List<EmployeeDto> entityToDto(List<Employee> employee){
        return employee.stream().map(employee1 -> entityToDto(employee1)).collect(Collectors.toList());
    }



    public Employee dtoToEntity(EmployeeDto dto){
        Employee employee=new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setDepartment(dto.getDepartment());
        return employee;
    }

    public List<Employee> dtoToEntity(List<EmployeeDto> dtos){
        return dtos.stream().map(dto -> dtoToEntity(dto)).collect(Collectors.toList());
    }


}
