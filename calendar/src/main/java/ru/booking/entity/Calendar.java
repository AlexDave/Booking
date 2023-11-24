package ru.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="calendar")
public class Calendar {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "checkin")
    private String checkin;

    @Column(name = "checkout")
    private String checkout;

}