package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    Optional<User> readByEmail(String email);

    //Write a derived query to read a user with a username?

    Optional<User> readByUsername(String username);

    //Write a derived query to list all users that contain a specific name?

    List<User> findByAccount_NameContains(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?

    List<User> findByAccount_NameContainsIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?

    List<User> findByAccount_AgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?

    @Query("SELECT u FROM User u WHERE u.email = ?1 ")
    Optional<User> fetchByEmail(String email);

    //Write a JPQL query that returns a user read by username?

    @Query("SELECT u FROM User u WHERE u.username = ?1 ")
    Optional<User> fetchByUsername(String Username);

    //Write a JPQL query that returns all users?

    @Query("SELECT u FROM User u")
    List<User> fetchAll();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    @Query(
            value = "SELECT * FROM user_account ua " +
                    "JOIN account_details ad ON ad.id = ua.account_details_id" +
                    "WHERE ad.name ILIKE CONCAT('%',?1,'%')"
            ,nativeQuery = true)
    List<User> retrieveByUsername(String name);

    //Write a native query that returns all users?

    @Query(value = "SELECT * FROM user_account " ,nativeQuery = true)
    List<User> retrieveAll();

    //Write a native query that returns all users in the range of ages?

    @Query(
            value = "SELECT * FROM user_account ua " +
                    "JOIN account_details ad ON ad.id = ua.account_details_id" +
                    "WHERE ad.age BETWEEN ?1 AND ?2"
            ,nativeQuery = true)
    List<User> retrieveAllByAge(Integer age1, Integer age2);

    //Write a native query to read a user by email?

    @Query(
            value = "SELECT * FROM user_account WHERE email = ?1"
            ,nativeQuery = true)
    List<User> retrieveAllByEmail(String email);

}
