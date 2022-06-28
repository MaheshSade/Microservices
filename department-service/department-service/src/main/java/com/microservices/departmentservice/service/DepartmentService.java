package com.microservices.departmentservice.service;

import com.microservices.departmentservice.model.Department;
import com.microservices.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repo;

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Optional<Department> getDepartment(int id) {
        return repo.findById(id);
    }
}
