package com.hospitalproject.hospital.project.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date appointmentDate;

    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn // optional
    private Patient foreignPatient;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;
}
