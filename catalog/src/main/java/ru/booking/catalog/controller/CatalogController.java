package ru.booking.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.booking.catalog.data.Apartment;
import ru.booking.catalog.model.response.FreeDates;
import ru.booking.catalog.service.CatalogService;

import java.util.List;

@RestController
@RequestMapping(path = "api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping
    public List<Apartment> getApartments() {
        return catalogService.findAllApartments();
    }

    @Value("${calendar.url}")
    private String devUrl;

    @GetMapping(path = "/freeDates", params = {"id"})
    public FreeDates getFreeDatesForApartment(RestTemplate restTemplate, @RequestParam(value = "id") Long id) {

        return restTemplate.getForObject(
        devUrl + "?id=" + id, FreeDates.class);


    }

    @GetMapping(params = {"city"})
    public List<Apartment> getApartmentsByCity(@RequestParam(value = "city") String city) {
        return catalogService.findByCity(city);
    }

    @GetMapping(params = {"price"})
    public List<Apartment> getApartmentsByPrice(@RequestParam(value = "price") Long price) {
        return catalogService.findByPriceForDayIsLessThanEqual(price);
    }

    @GetMapping(params = {"petsFriendly"})
    public List<Apartment> getApartmentsWithPetsFilter(@RequestParam(value = "petsFriendly") Boolean isAvailableForPets) {
        return catalogService.findByPetsFriendly(isAvailableForPets);
    }

    @GetMapping(params = {"kidsAvailable"})
    public List<Apartment> getApartmentsWithKidsFilter(@RequestParam(value = "kidsAvailable") Boolean isAvailableForKids) {
        return catalogService.findByKidsAvailable(isAvailableForKids);
    }


/*    @GetMapping(value = "/petsFriendly")
    public List<Apartment> getApartmentsWithPets() {
        return catalogService.findByPetsFriendly();
    }

/*    @GetMapping(params = {"kidsFriendly"})
    public List<Apartment> getApartmentsWithKids() {
        return catalogService.findByKidsFriendly();
    }*/

    @PostMapping
    public void addNewApartment(@RequestBody Apartment apartment) {
        catalogService.addNewApartment(apartment);
    }

    @DeleteMapping(path = "{apartmentId}")
    public void deleteApartment(@PathVariable Long apartmentId) {
        catalogService.deleteApartment(apartmentId);
    }


}
