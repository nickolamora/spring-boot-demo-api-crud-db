package com.nickolamora.springbootdemodailycodebuffer.service;

import static org.junit.jupiter.api.Assertions.*;

import com.nickolamora.springbootdemodailycodebuffer.entity.Department;
import com.nickolamora.springbootdemodailycodebuffer.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//Tells Spring this is a test class
@SpringBootTest
class DepartmentServiceImplTest {

  @Autowired
  private DepartmentService departmentService;

  //Mocks that bean
  @MockBean
  private DepartmentRepository departmentRepository;

  @BeforeEach
  void setUp() {
    Department department = Department.builder()
        .departmentName("IT")
        .departmentAddress("NY")
        .departmentId(1L)
        .departmentCode("IT-929")
        .build();
    Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
  }

  @Test
  @DisplayName("Get Data based on Valid Department Name")
//  @Disabled This skips this unit test
  public void whenValidDepartmentName_thenDepartmentShouldFound() {
    String departmentName = "IT";
    Department found = departmentService.fetchDepartmentByName(departmentName);
    assertEquals(departmentName, found.getDepartmentName());
  }

}