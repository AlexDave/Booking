package ru.booking.catalog.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.booking.catalog.data.Apartment;
import ru.booking.catalog.repository.CatalogRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;
    public List<Apartment> findAllApartments() {
        return catalogRepository.findAll();
    }

    public void addNewApartment(Apartment apartment) {
        catalogRepository.save(apartment);
    }

    public void deleteApartment(Long apartmentId) {
        catalogRepository.deleteById(apartmentId);
    }

    public List<Apartment> findByCity(String city) {
        return catalogRepository.findByCity(city);
    };

    public List<Apartment> findByPriceForDayIsLessThanEqual(Long sum) {
        return catalogRepository.findByPriceForDayIsLessThanEqual(sum);
    };

 /*   public List<Apartment> findByPetsFriendly(Boolean isAvailableForPets) {
        return catalogRepository.findByPetsFriendly(isAvailableForPets);
    };

    public List<Apartment> findByKidsAvailable(Boolean isAvailableForKids) {
        return catalogRepository.findByKidsFriendly(isAvailableForKids);
    };*/

}
