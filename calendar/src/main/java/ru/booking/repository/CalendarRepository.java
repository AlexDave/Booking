package ru.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.booking.entity.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, String> {
    Calendar findCalendarById(@Param("id") String id);
}
