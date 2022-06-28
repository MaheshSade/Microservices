package com.microservices.userservice.controller;

import com.microservices.userservice.VO.Department;
import com.microservices.userservice.VO.RestTemplateVO;
import com.microservices.userservice.model.User;
import com.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
//    @GetMapping("/{id}")
//    public Optional<User> getUser(@PathVariable int id){
//        return service.getUser(id);
//    }

    @GetMapping("/{id}")
    public RestTemplateVO getUserWithDept(@PathVariable int id){
        RestTemplateVO vo = new RestTemplateVO();
        User user = service.getUser(id).get();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+id,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
