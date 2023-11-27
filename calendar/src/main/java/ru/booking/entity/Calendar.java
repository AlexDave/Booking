package ru.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name ="calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "id")
    private Long id;

    @Column(name = "checkin")
    private LocalDate checkin;

    @Column(name = "checkout")
    private LocalDate checkout;

}