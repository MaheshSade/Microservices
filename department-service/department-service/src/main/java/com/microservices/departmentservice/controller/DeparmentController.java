package com.microservices.departmentservice.controller;

import com.microservices.departmentservice.model.Department;
import com.microservices.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DeparmentController {

    @Autowired
    DepartmentService service;

    @GetMapping("")
    public List<Department> getAllUsers(){
        return service.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Optional<Department> getUser(@PathVariable int id){
        return service.getDepartment(id);
    }

}
