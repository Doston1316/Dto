package com.xadmin.dto.service;

import com.xadmin.dto.Dto.DepartmentDto;
import com.xadmin.dto.model.Department;
import com.xadmin.dto.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }
}
