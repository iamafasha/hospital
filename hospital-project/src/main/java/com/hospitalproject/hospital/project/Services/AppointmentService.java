package com.hospitalproject.hospital.project.Services;

import com.hospitalproject.hospital.project.DTOs.AppointmentDto;
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

    public String bookAppointment(AppointmentDto appointmentDto){
        Optional<Doctor> doctorOptional= doctorRepository.findById(appointmentDto.getDoctorId());
        Doctor doctor = doctorOptional.get();

        Optional<Patient>patientOptional = patientRepository.findById(appointmentDto.getPatientId());
        Patient patient = patientOptional.get();

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        //saving the appointment and getting the id to prevent duplicating values
        Appointment appointment1=appointmentRepository.save(appointment);


        //setting the values in the parent
        doctor.getAppointments().add(appointment1);
        doctorRepository.save(doctor);

        patient.getAppointments().add(appointment1);
        patientRepository.save(patient);





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
        appointment1.setPatient(patient);
        appointment1.setDoctor(doctor);



        patient.getAppointments().add(appointment1);
        patientRepository.save(patient);

        return "patient has been associated";
    }
}
