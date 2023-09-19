package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //display all employees with email address
    List<Employee> findByEmail(String email);

    //display all employees with firstname and lastname
    List<Employee> getByFirstNameAndLastName(String firstName, String lastName);

    //display all employees with email address, and show employees with email
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //display all employees where first name is not input parameter
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with input parameter
    List<Employee> findByLastNameStartsWith(String lastName);

    //display employees whose salary is higher than input parameter
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display employees whose salary is less than input parameter
    List<Employee> findBySalaryLessThan(Integer salary);

    //display employees whose hire data is between two input parameters date
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //display all employees with order where salary is greater and equal to input parameter
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //display top unique 3 employees that making less than input parameter
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees that does not have email
    List<Employee> findByEmailIsNull();

    /*
    ==============================
    JPQL (Java Persistent Query Language)
    ==============================
     */

    @Query("SELECT employee FROM Employee employee WHERE employee.email = 'dtrail8@tamu.edu'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Integer retrieveEmployeeSalary();



}
