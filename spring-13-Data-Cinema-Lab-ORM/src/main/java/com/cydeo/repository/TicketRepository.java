package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought

    Long countByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email

    List<Ticket> getByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie

    Long countByMovieCinemaMovieId(Long movieId);
    Long countByMovieCinemaMovieName(String movieName);

    //Write a derived query to list all tickets between a range of dates

    List<Ticket> readAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user

    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id = ?1 ")
    List<Ticket> fetchAllByUser(Long userAccountId);

    //Write a JPQL query that returns all tickets between a range of dates

    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> fetchAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1" ,nativeQuery = true)
    Long getCountByUser(Long userAccountId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates

    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3" ,nativeQuery = true)
    Long retrieveAllByDateTimeBetween(Long userId,LocalDateTime dateTime1, LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name

    @Query(
            value = "SELECT DISTINCT(m.name) FROM ticket t" +
            "JOIN movie_cinema mc ON t.movie_cinema_id = mc.id" +
                    "JOIN movie m ON mc.cinema_id = m.id"
            ,nativeQuery = true)
    List<String> distinctAllByName();

    //Write a native query to find all tickets by user email

    @Query(
            value = "SELECT * FROM ticket t JOIN user_account u ON t.user_account_id = u.id" +
            "WHERE u.email = ?1"
            ,nativeQuery = true)
    List<Ticket> retrieveAllByEmail(String email);

    //Write a native query that returns all tickets

    @Query(value = "SELECT * FROM ticket" ,nativeQuery = true)
    List<Ticket> fetchAll();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name

    @Query(
            value = "SELECT * FROM ticket t " +
                    "JOIN user_account u ON t.user_account_id = u.id" +
                    "JOIN account_details ad ON u.account_details_id = ad.id" +
                    "JOIN movie_cinema mc ON t.movie_cinema_id = mc.id" +
                    "JOIN movie m ON mc.movie_id = m.id" +
                    "WHERE u.username ILIKE '%'|| ?1 ||'%' " +
                    "OR ad.name ILIKE '%'|| ?1 ||'%'" +
                    "OR m.name ILIKE '%'|| ?1 ||'%'"
            ,nativeQuery = true
    )
    List<Ticket> fetchByUsernameOrAccountNameOrMovieName(String input);


}
