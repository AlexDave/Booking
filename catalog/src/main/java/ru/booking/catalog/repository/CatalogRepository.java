package ru.booking.catalog.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.booking.catalog.data.Apartment;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Apartment, Long>, JpaSpecificationExecutor<Apartment> {

    List<Apartment> findByCity(String city);
    List<Apartment> findByPriceForDayIsLessThanEqual(Long sum);

    List<Apartment> findByPetsFriendly(Boolean isAvailableForPets);

    List<Apartment> findByKidsFriendly(Boolean isAvailableForKids);

    Apartment findApartmentById(Long id);

}