package ru.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.booking.entity.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, String> {

    Calendar findCalendarById(@Param("id") Long id);

}
