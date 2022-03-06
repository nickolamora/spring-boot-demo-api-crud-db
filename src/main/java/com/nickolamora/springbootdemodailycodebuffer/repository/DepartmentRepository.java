package com.nickolamora.springbootdemodailycodebuffer.repository;

import com.nickolamora.springbootdemodailycodebuffer.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * contains @Component that tells Spring that this should be a class that should be handled as a bean in the Spring container.
 *
 * annotates classes at the persistence layer, which will act as a database repository.
 */
@Repository
//Here we are extending JPA Repository to inherit all the properties from another class or an interface that wants to inherit an interface
//JpaRepository <Entity, Primary Key Type>
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  //These are queries created using method names https://spring.getdocs.org/en-US/spring-data-docs/spring-data-jpa/reference/jpa.repositories/jpa.query-methods.html
  // https://www.baeldung.com/spring-data-derived-queries
  //https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbDZ5N2J4OFp0cnd2X3F5QjliQ0VoblJGUVRfZ3xBQ3Jtc0ttUnhyYm4temJyZUh4R1JiSWtNRGdCUjF0Vmp5X05SeG5QSHZTdFk4Z3hzd1l3NnRDM3pjWk92YndyODRKQzFrbGs5NGtsdDJ4eGJnYkk2all2bmd0VFg4aGJUT0h5cUw3U1Q2cUN4ZXB4YTZaODhpbw&q=https%3A%2F%2Fdocs.spring.io%2Fspring-data%2Fjpa%2Fdocs%2Fcurrent%2Freference%2Fhtml%2F%23jpa.query-methods
  Department findByDepartmentName(String departmentName);

  Department findByDepartmentNameIgnoreCase(String departmentName);
}
