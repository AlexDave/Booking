package ru.booking.catalog.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.booking.catalog.data.Apartment;
import ru.booking.catalog.model.ApartmentResponse;
import ru.booking.catalog.model.Catalog;
import ru.booking.catalog.model.FreeDates;
import ru.booking.catalog.repository.CatalogRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;
    public Catalog findAllApartments() {
        return new Catalog(catalogRepository.findAll());
    }

    public Apartment findApartmentById(Long id) {
        return catalogRepository.findApartmentById(id);
    }

    public void addNewApartment(Apartment apartment) {
        catalogRepository.save(apartment);
    }

    public void deleteApartment(Long apartmentId) {
        catalogRepository.deleteById(apartmentId);
    }

    public Catalog findByCity(String city) {
        return new Catalog(catalogRepository.findByCity(city));
    };

    public Catalog findByPriceForDayIsLessThanEqual(Long sum) {
        return new Catalog(catalogRepository.findByPriceForDayIsLessThanEqual(sum));
    };

   public Catalog findByPetsFriendly(Boolean isAvailableForPets) {
       return new Catalog(catalogRepository.findByPetsFriendly(isAvailableForPets));
    };

    public Catalog findByKidsAvailable(Boolean isAvailableForKids) {
        return new Catalog(catalogRepository.findByKidsFriendly(isAvailableForKids));
    };

    /*public String getInfoAboutApartment(Long id, FreeDates freeDates){
        Apartment apartment = findApartmentById(id);
        String availableForKids = apartment.isKidsFriendly() ? "да" : "нет";
        String petsFriendly = apartment.isPetsFriendly() ? "да" : "нет";
        return "Апартаменты по адресу " + apartment.getAddress() + " в городе " + apartment.getCity() + "\n" +
                "Доступно к бронированию с детьми? " + availableForKids + "\n" +
                "Доступно проживание с домашними животными? " + petsFriendly + "\n" +
                "Даты, доступные к бронированию: " + freeDates.toString();
    }*/

    public ApartmentResponse getInfoAboutApartment(Long id, FreeDates freeDates){
        Apartment apartment = findApartmentById(id);
        return new ApartmentResponse(apartment, freeDates);
    }

}
