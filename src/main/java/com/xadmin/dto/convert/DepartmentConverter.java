package com.xadmin.dto.convert;

import com.xadmin.dto.Dto.DepartmentDto;
import com.xadmin.dto.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentConverter {

   public DepartmentDto entityToDto(Department department){
        DepartmentDto dto=new DepartmentDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setCode(department.getCode());
        return dto;
    }

    public List<DepartmentDto>entityToDto(List<Department>departments){
       return departments.stream().map(department -> entityToDto(department)).collect(Collectors.toList());
    }

    public Department dtoToEntity(DepartmentDto dto){
       Department department=new Department();
       department.setId(dto.getId());
       department.setName(dto.getName());
       department.setCode(dto.getCode());
       return department;
    }

    public List<Department>dtoToEntity(List<DepartmentDto>dtos){
        return dtos.stream().map(department -> dtoToEntity(department)).collect(Collectors.toList());
    }

}
