package com.gl.training.spring.mvc.labspringmvc1.repository;

import com.gl.training.spring.mvc.labspringmvc1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
}
