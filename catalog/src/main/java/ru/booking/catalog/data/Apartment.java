package ru.booking.catalog.data;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "apartments")
@Data
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price_for_day")
    private Long priceForDay;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "is_pets_friendly")
    private boolean petsFriendly;

    @Column(name = "is_kids_friendly")
    private boolean kidsFriendly;


    public Apartment(Long id, String city, String address, boolean isKidsFriendly, boolean isPetsFriendly) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.kidsFriendly = isKidsFriendly;
        this.petsFriendly = isPetsFriendly;
    }


/*    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", realEstateId=" + realEstateId +
                ", orderCategory='" + orderCategory + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderDateFrom=" + orderDateFrom +
                ", orderDateTo=" + orderDateTo +
                ", statusId=" + statusId +
                '}';
    }
 */

}
