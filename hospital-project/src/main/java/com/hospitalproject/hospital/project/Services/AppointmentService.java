package com.hospitalproject.hospital.project.Services;

import com.hospitalproject.hospital.project.Models.Appointment;
import com.hospitalproject.hospital.project.Models.Doctor;
import com.hospitalproject.hospital.project.Models.Patient;
import com.hospitalproject.hospital.project.Repository.AppointmentRepository;
import com.hospitalproject.hospital.project.Repository.DoctorRepository;
import com.hospitalproject.hospital.project.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public String bookAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
        return "appointment created";
    }

    public String assignAppointment(int appId, int patientId, int docId) {
        Optional<Appointment>appointmentOptional = appointmentRepository.findById(appId);
        Appointment appointment = appointmentOptional.get();

        Optional< Patient> patientOptional = patientRepository.findById(patientId);
        Patient patient = patientOptional.get();

        Optional<Doctor>doctorOptional = doctorRepository.findById(docId);
        Doctor doctor = doctorOptional.get();

        Appointment appointment1 = new Appointment();
        appointment1.setAppointmentDate(appointment.getAppointmentDate());
        appointment1.setAppointmentTime(appointment.getAppointmentTime());
        appointment1.setForeignPatient(patient);
        appointment1.setDoctor(doctor);



        patient.getAppointments().add(appointment1);
        patientRepository.save(patient);

        return "patient has been associated";
    }
}
