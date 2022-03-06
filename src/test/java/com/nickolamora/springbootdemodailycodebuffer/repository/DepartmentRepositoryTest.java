package com.nickolamora.springbootdemodailycodebuffer.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.nickolamora.springbootdemodailycodebuffer.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * This is used for testing the repository where it will persist the data
 * to the DB and then flush it out
 */
@DataJpaTest
class DepartmentRepositoryTest {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Autowired
  //allows you to temporarily persist and flush data
  private TestEntityManager testEntityManager;

  @BeforeEach
  void setUp() {

    Department department = Department.builder()
        .departmentName("Mechanical Engineering")
        .departmentCode("ME-011")
        .departmentAddress("NY")
        .build();

    testEntityManager.persist(department);
  }

  @Test
  public void whenFindById_ThenReturnDepartment() {
    Department department = departmentRepository.findById(1L).get();
    assertEquals(department.getDepartmentName(), "Mechanical Engineering");
  }

}