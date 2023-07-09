package com.hospitalproject.hospital.project.Models;

import com.hospitalproject.hospital.project.Enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity //annotation specify entity in the table
@Table(name = "patients")
@Data

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phoneNumber;
    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Appointment>appointments = new ArrayList<>();
}
