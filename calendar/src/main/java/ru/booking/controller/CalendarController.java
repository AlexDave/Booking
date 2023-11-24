package ru.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.booking.entity.Calendar;
import ru.booking.service.CalendarService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping(value = "/findFreeDates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findFreeDatesById(@RequestParam("id") Long id) {
        List<LocalDate> listFreeDates;
        Calendar calendar = calendarService.findCalendarById(id);
        if (calendar.getCheckout() == null) {
            listFreeDates = getListFromNowDate();
        } else {
            listFreeDates = getFreeDates(calendar.getCheckin(), calendar.getCheckout());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("freeDate", listFreeDates));
    }

    @GetMapping("/findAll")
    public Collection<Calendar> findAllBooking() {
        return calendarService.findAllBooking();
    }

    @PostMapping("/save")
    public int saveBooking(@RequestBody Calendar calendar) {
        calendarService.saveCalendar(calendar);
        return getEveryDate(calendar.getCheckin(), calendar.getCheckout()).size();
    }

    /**
     * Получаю список дат, доступных для бронирования.
     *
     * @param checkIn  дата начала брони
     * @param checkOut дата окончания брони
     * @return список дат, доступных для бронирования
     */
    private static List<LocalDate> getFreeDates(LocalDate checkIn, LocalDate checkOut) {
        List<LocalDate> listFromDB = getListFromDB(checkIn, checkOut);
        List<LocalDate> listFromNowDate = getListFromNowDate();
        listFromNowDate.removeAll(listFromDB);
        return listFromNowDate;
    }

    /**
     * Получаю данные из БД.
     *
     * @param checkIn  дата начала брони
     * @param checkOut дата окончания брони
     * @return список всех дат за период
     */
    private static List<LocalDate> getListFromDB(LocalDate checkIn, LocalDate checkOut) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate startDate = LocalDate.parse(checkIn, formatter);
//        LocalDate endDate = LocalDate.parse(checkOut, formatter);
        return getEveryDate(checkIn, checkOut);
    }

    /**
     * Получаю список всех дат с текущего дня плюс 30 дней.
     *
     * @return список всех дат за период
     */
    private static List<LocalDate> getListFromNowDate() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(30);
        return getEveryDate(startDate, endDate);
    }

    /**
     * @param startDate начальная дата
     * @param endDate   конечная дата
     * @return список всех дат за период
     */
    private static List<LocalDate> getEveryDate(LocalDate startDate, LocalDate endDate) {
        long numOfDays = ChronoUnit.DAYS.between(startDate, endDate);
        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(numOfDays)
                .collect(Collectors.toList());
    }

//    @GetMapping("/all")
//    public Collection<Calendar> getAll(@RequestParam("id") Long id){
//        return calendarService.findCalendars(id);
//    }
}
