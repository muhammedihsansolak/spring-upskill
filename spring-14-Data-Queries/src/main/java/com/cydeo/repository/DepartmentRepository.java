package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    //display all departments in furniture department
    List<Department> findByDepartment(String department);

    //display all departments in health division
    List<Department> getByDivision(String division);
    List<Department> getByDivisionIs(String division);
    List<Department> getByDivisionEquals(String division);

    //display all departments with division if name ends with 'ics'
    List<Department> findByDivisionEndingWith(String division);

    //display top 3 departments with division if name includes 'Hea' without duplicates
    List<Department> getDistinctTop3ByDivisionContaining(String division);

    @Query("select d from Department d where d.division in ?1")
    List<Department> retrieveDepartmentDivision(List<String> division);


}
