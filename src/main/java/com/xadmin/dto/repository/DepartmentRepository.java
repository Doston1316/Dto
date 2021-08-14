package com.xadmin.dto.repository;

import com.xadmin.dto.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
