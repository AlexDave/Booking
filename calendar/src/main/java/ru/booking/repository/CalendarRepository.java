package ru.booking.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.booking.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, String> {

//    @Modifying
//    @Transactional
//    @Query("INSERT INTO Calendar (id, checkin, checkout) VALUES (:id, :checkin, :checkout)")
//    void createCalendar(@Param("id") String id, @Param("checkin") String checkin, @Param("checkout")String checkout);
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE Calendar SET checkin = :checkin, checkout = :checkout WHERE id = :id")
//    void updateCalendar(@Param("id") String id, @Param("checkin") String checkin, @Param("checkout")String checkout);

    Calendar findCalendarById(@Param("id") String id);


}
