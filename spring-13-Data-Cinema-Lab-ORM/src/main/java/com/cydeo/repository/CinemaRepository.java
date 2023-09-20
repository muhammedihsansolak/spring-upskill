package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name

    List<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String name);

    //Write a derived query to list all cinemas in a specific country

    List<Cinema> findByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name

    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id

    @Query("SELECT c.name FROM Cinema c where c.id = ?1")
    Optional<String> fetchById(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country

    @Query(value = "select * from cinema c join location l on c.location_id = l.id where l.country = ?1" ,nativeQuery = true)
    List<Cinema> fetchAllByLocationCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern

    @Query(value = "SELECT * FROM cinema WHERE name like concat('%',?1,'%') OR sponsored_name like concat('%',?2,'%')" ,nativeQuery = true)
    List<Cinema> fetchByNameOrSponsoredName(String name, String sponsoredName);

    //Write a native query to sort all cinemas by name

    @Query(value = "SELECT * FROM cinema ORDER BY name ASC " ,nativeQuery = true)
    List<Cinema> fetchAllByNameSorted();

    //Write a native query to distinct all cinemas by sponsored name

    @Query(value = "SELECT DISTINCT sponsored_name FROM cinema " ,nativeQuery = true)
    List<Cinema> fetchUniqueSponsoredNames();











}
