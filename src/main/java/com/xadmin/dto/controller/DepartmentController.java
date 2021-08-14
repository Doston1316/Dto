package com.xadmin.dto.controller;

import com.xadmin.dto.Dto.DepartmentDto;
import com.xadmin.dto.convert.DepartmentConverter;
import com.xadmin.dto.model.Department;
import com.xadmin.dto.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentConverter departmentConverter;



    @GetMapping("/")
    public List<DepartmentDto> findAll(){
        List<Department>findAll=departmentService.findAll();
        return departmentConverter.entityToDto(findAll);
    }

    @PostMapping("/")
    public DepartmentDto save(@RequestBody DepartmentDto dto){
        Department department=departmentConverter.dtoToEntity(dto);
         department=departmentService.save(department);
        return departmentConverter.entityToDto(department);
    }

}
