package com.hospitalproject.hospital.project.DTOs;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentDto {
    private Date appointmentDate;
    private LocalTime appointmentTime;
    private int doctorId;
    private int patientId;
}
