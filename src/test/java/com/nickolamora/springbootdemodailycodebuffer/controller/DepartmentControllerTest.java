package com.nickolamora.springbootdemodailycodebuffer.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.nickolamora.springbootdemodailycodebuffer.entity.Department;
import com.nickolamora.springbootdemodailycodebuffer.error.DepartmentNotFoundException;
import com.nickolamora.springbootdemodailycodebuffer.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * We use WebMVCTest to test the Controller class
 */
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DepartmentService departmentService;

  private Department department;

  @BeforeEach
  void setUp() {

    department = Department.builder()
        .departmentName("IT")
        .departmentCode("IT-929")
        .departmentAddress("NY")
        .departmentId(1L)
        .build();
  }

  @Test
  void saveDepartment() throws Exception {

    Department inputDepartment = Department.builder()
        .departmentName("IT")
        .departmentCode("IT-929")
        .departmentAddress("NY")
        .build();

    //Mock the service call the controller does
    Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

    //Makes the Rest call and expects a 200
    mockMvc.perform(post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "  \"departmentName\": \"IT\",\n" +
            "  \"departmentAddress\": \"NY\",\n" +
            "  \"departmentCode\": \"IT-929\"\n" +
            "}"))
        .andExpect(status().isOk());
  }

  @Test
  void fetchDepartmentById() throws Exception {

    //Mock the service call the controller does
    Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

    //Makes the Rest call and expects a 200
    mockMvc.perform(get("/departments/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
  }

}