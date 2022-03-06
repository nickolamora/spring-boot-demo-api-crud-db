package com.nickolamora.springbootdemodailycodebuffer.service;

import java.util.List;

import com.nickolamora.springbootdemodailycodebuffer.entity.Department;
import com.nickolamora.springbootdemodailycodebuffer.error.DepartmentNotFoundException;

public interface DepartmentService {

  Department saveDepartment(Department department);

  List<Department> fetchDepartmentList();

  Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  void deleteDepartmentById(Long departmentId);

  Department updateDepartment(Long departmentId, Department department);

  Department fetchDepartmentByName(String departmentName);
}
