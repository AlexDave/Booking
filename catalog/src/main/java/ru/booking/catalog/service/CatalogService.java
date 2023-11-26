package ru.booking.catalog.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.booking.catalog.data.Apartment;
import ru.booking.catalog.dto.ApartmentWithFreeDatesDto;
import ru.booking.catalog.dto.CatalogDto;
import ru.booking.catalog.dto.FreeDatesDto;
import ru.booking.catalog.repository.CatalogRepository;

@Service
@AllArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;
    public CatalogDto findAllApartments() {
        return new CatalogDto(catalogRepository.findAll());
    }

    public Apartment findApartmentById(Long id) {
        return catalogRepository.findApartmentById(id);
    }

    public ApartmentWithFreeDatesDto getInfoAboutApartment(Long id, FreeDatesDto freeDates){
        Apartment apartment = findApartmentById(id);
        return new ApartmentWithFreeDatesDto(apartment, freeDates);
    }

    //Поиск по фильтрам
    public CatalogDto findByCity(String city) {
        return new CatalogDto(catalogRepository.findByCity(city));
    };

    public CatalogDto findByPriceForDayIsLessThanEqual(Long sum) {
        return new CatalogDto(catalogRepository.findByPriceForDayIsLessThanEqual(sum));
    };

    public CatalogDto findByPetsFriendly(Boolean isAvailableForPets) {
        return new CatalogDto(catalogRepository.findByPetsFriendly(isAvailableForPets));
    };

    public CatalogDto findByKidsAvailable(Boolean isAvailableForKids) {
        return new CatalogDto(catalogRepository.findByKidsFriendly(isAvailableForKids));
    };

    //CRUD-операции
    public void addNewApartment(Apartment apartment) {
        catalogRepository.save(apartment);
    }

    public void deleteApartment(Long apartmentId) {
        catalogRepository.deleteById(apartmentId);
    }
}
