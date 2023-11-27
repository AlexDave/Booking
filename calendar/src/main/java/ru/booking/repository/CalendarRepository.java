package ru.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.booking.entity.Calendar;

import java.util.Collection;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, String> {

    Calendar findCalendarById(@Param("id") Long id);

    Collection<Calendar> findAllById(@Param("id") Long id);
}
