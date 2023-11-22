package ru.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    private String checkin;

    private String checkout;

}