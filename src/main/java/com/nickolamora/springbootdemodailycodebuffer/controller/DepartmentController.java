package com.nickolamora.springbootdemodailycodebuffer.controller;

import javax.validation.Valid;
import java.util.List;

import com.nickolamora.springbootdemodailycodebuffer.entity.Department;
import com.nickolamora.springbootdemodailycodebuffer.error.DepartmentNotFoundException;
import com.nickolamora.springbootdemodailycodebuffer.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// contains @Controller that tells Spring that this is the Controller class
// contains @Component that tells Spring that this should be a class that should be handled as a bean in the Spring container
// Tells Spring that this is a controller that will always return a response body
@RestController
@Slf4j
public class DepartmentController {

  // @Autowired - property based Autowire the object in the spring container into this class. There is also constructor based autowiring.
  //if there is more than one impl for an interface to autowire use @Qualifier to specify
//  @Qualifier("departmentServiceImpl")
  @Autowired
  private DepartmentService departmentService;

  @PostMapping("/departments")
  //@RequestBody will get the JSON in the Req body and convert it into a Department object
  public Department saveDepartment(@Valid @RequestBody Department department) {

    departmentService.saveDepartment(department);
    log.info("Saved Department {}", department);
    return department;
  }

  @GetMapping("/departments")
  public List<Department> fetchDepartmentList() {

    return departmentService.fetchDepartmentList();
  }

  @GetMapping("/departments/{id}")
  //@PathVariable will extract the variable from the path
  public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

    return departmentService.fetchDepartmentById(departmentId);
  }

  @DeleteMapping("/departments/{id}")
  //@PathVariable will extract the variable from the path
  public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
    departmentService.deleteDepartmentById(departmentId);
    return "Department deleted Successfully";
  }

  @PutMapping("/departments/{id}")
  //@PathVariable will extract the variable from the path
  public Department updateDepartment(@PathVariable("id") Long departmentId,
                                     @RequestBody Department department) {

    return departmentService.updateDepartment(departmentId, department);
  }

  @GetMapping("/departments/name/{departmentName}")
  public Department fetchDepartmentByName( @PathVariable String departmentName) {

    return departmentService.fetchDepartmentByName(departmentName);
  }
}
