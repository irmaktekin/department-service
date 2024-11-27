package com.irmaktekin.department_service.controller;

import com.irmaktekin.department_service.model.Department;
import com.irmaktekin.department_service.repository.DepartmentRepository;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department add(@RequestBody  Department department){
        LOGGER.info("Department add: {}",department);
        return departmentRepository.addDepartment(department);
    }
    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department find");
        return departmentRepository.findAll();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable  Long id){
        LOGGER.info("Department find: id={}",id);
        return departmentRepository.findById(id);
    }
}
