package com.nickolamora.springbootdemodailycodebuffer.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.nickolamora.springbootdemodailycodebuffer.entity.Department;
import com.nickolamora.springbootdemodailycodebuffer.error.DepartmentNotFoundException;
import com.nickolamora.springbootdemodailycodebuffer.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * contains @Component that tells Spring that this should be a class that should be handled as a bean in the Spring container.
 * <p>
 * annotates classes at the service layer.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public Department saveDepartment(Department department) {

    departmentRepository.save(department);
    return department;
  }

  @Override
  public List<Department> fetchDepartmentList() {

    return departmentRepository.findAll();
  }

  @Override
  public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

    Optional<Department> department = departmentRepository.findById(departmentId);

    if (!department.isPresent()) {
      throw new DepartmentNotFoundException("Department Not Available");
    }
    return department.get();
  }

  @Override
  public void deleteDepartmentById(Long departmentId) {
    departmentRepository.deleteById(departmentId);
  }

  @Override
  public Department updateDepartment(Long departmentId, Department department) {

    Department departmentFromDB = departmentRepository.findById(departmentId).get();

    if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
      departmentFromDB.setDepartmentName(department.getDepartmentName());
    }
    if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
      departmentFromDB.setDepartmentCode(department.getDepartmentCode());
    }
    if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
      departmentFromDB.setDepartmentAddress(department.getDepartmentAddress());
    }

    return departmentRepository.save(departmentFromDB);
  }

  @Override
  public Department fetchDepartmentByName(String departmentName) {
    return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
//    return departmentRepository.findByDepartmentName(departmentName);
  }
}
