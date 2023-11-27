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

    @GetMapping( value = "/findFreeDates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findFreeDatesById(@RequestParam("id") Long id) {
        List<LocalDate> listFreeDates = new ArrayList<>();
        for(Calendar calendar: calendarService.findAllById(id)) {
            if (calendar.getCheckout() == null) {
                listFreeDates.addAll(getListFromNowDate());
            } else {
                for(LocalDate lc : getFreeDates(calendar.getCheckin(), calendar.getCheckout())){
                    if (!listFreeDates.contains(lc)) {
                        listFreeDates.add(lc);
                    }
                }
                for(LocalDate lc: getEveryDate(calendar.getCheckin(), calendar.getCheckout())){
                    listFreeDates.remove(lc);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("freeDate", listFreeDates));
    }

    @GetMapping("/findAll")
    public Collection<Calendar> findAllBooking() {
        return calendarService.findAllBooking();
    }

    @GetMapping("/findAllById")
    public Collection<Calendar> findAllById(@RequestParam("id") Long id){
        return calendarService.findAllById(id);
    }

    @PostMapping("/save")
    public int saveBooking(@RequestBody Calendar calendar) {
        if(checkDates(calendar)) {
            calendarService.saveCalendar(calendar);
            return getEveryDate(calendar.getCheckin(), calendar.getCheckout()).size();
        }else{
            return -1;
        }
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

    private boolean checkDates(Calendar calendar){
        for (Calendar c : calendarService.findAllById(calendar.getId())) {
            if (checkAfter(calendar.getCheckin(),c.getCheckin()) && checkBefore(calendar.getCheckin(),c.getCheckout())) {
                return false;
            }
            else if (checkAfter(calendar.getCheckout(),c.getCheckin()) && checkBefore(calendar.getCheckout(),c.getCheckout())) {
                return false;
            }
            else if(checkBefore(calendar.getCheckin(),c.getCheckin()) && checkAfter(calendar.getCheckout(),c.getCheckout())){
                return false;
            }
        }
        return true;
    }

    private boolean checkAfter(LocalDate ld1, LocalDate ld2){
        return  ld1.equals(ld2) || ld1.isAfter(ld2);
    }
    private boolean checkBefore(LocalDate ld1, LocalDate ld2){
        return  ld1.equals(ld2) || ld1.isBefore(ld2);
    }



//    @GetMapping("/all")
//    public Collection<Calendar> getAll(@RequestParam("id") Long id){
//        return calendarService.findCalendars(id);
//    }
}
