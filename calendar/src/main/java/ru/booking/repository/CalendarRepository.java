package ru.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.booking.entity.Calendar;

import java.util.Collection;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, String> {
    Calendar findCalendarById(@Param("id") String id);
    List<Calendar> findCalendarsByStatusAndCheckinAndCheckout(@Param("status") String status, @Param("checkin") String checkIn, @Param("checkout") String checkOut);
    Collection<Calendar> findCalendarsByCheckinAndCheckout(@Param("checkin") String checkIn, @Param("checkout") String checkOut);
    List<Calendar> findCalendarsByStatus(@Param("status") String status);


}
