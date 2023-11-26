package ru.booking.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.booking.catalog.data.Apartment;
import ru.booking.catalog.dto.ApartmentWithFreeDatesDto;
import ru.booking.catalog.dto.CatalogDto;
import ru.booking.catalog.dto.FreeDatesDto;
import ru.booking.catalog.service.CatalogService;

@RestController
@RequestMapping(path = "api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Value("${calendar.url}")
    private String devUrl;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping
    public CatalogDto getCatalog() {

        return catalogService.findAllApartments();
    }

    @GetMapping(path = "/getInfo", params = {"id"})
    public Apartment getInfoAboutApartment(@RequestParam(value = "id") Long id) {

        return catalogService.findApartmentById(id);

    }

    @GetMapping(path = "/getInfoWithFreeDates", params = {"id"})
    public ApartmentWithFreeDatesDto getFreeDatesForApartment(RestTemplate restTemplate, @RequestParam(value = "id") Long id) {


        FreeDatesDto freeDates = restTemplate.getForObject(
                devUrl + "?id=" + id, FreeDatesDto.class);
        assert freeDates != null;
        return catalogService.getInfoAboutApartment(id, freeDates);

    }


    //Поиск квартиры по фильтрам
    @GetMapping(params = {"city"})
    public CatalogDto getApartmentsByCity(@RequestParam(value = "city") String city) {
        return catalogService.findByCity(city);
    }

    @GetMapping(params = {"price"})
    public CatalogDto getApartmentsByPrice(@RequestParam(value = "price") Long price) {
        return catalogService.findByPriceForDayIsLessThanEqual(price);
    }

    @GetMapping(params = {"petsFriendly"})
    public CatalogDto getApartmentsWithPetsFilter(@RequestParam(value = "petsFriendly") Boolean isAvailableForPets) {
        return catalogService.findByPetsFriendly(isAvailableForPets);
    }

    @GetMapping(params = {"kidsAvailable"})
    public CatalogDto getApartmentsWithKidsFilter(@RequestParam(value = "kidsAvailable") Boolean isAvailableForKids) {
        return catalogService.findByKidsAvailable(isAvailableForKids);
    }


    //CRUD-операции
    @PostMapping
    public void addNewApartment(@RequestBody Apartment apartment) {
        catalogService.addNewApartment(apartment);
    }

    @DeleteMapping(path = "{apartmentId}")
    public void deleteApartment(@PathVariable Long apartmentId) {
        catalogService.deleteApartment(apartmentId);
    }


}
