package com.hospitalproject.hospital.project.Services;

import com.hospitalproject.hospital.project.Models.Patient;
import com.hospitalproject.hospital.project.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public String register(Patient patient){
        patientRepository.save(patient);
        return "patient "+patient.getName()+ " has been registered";
    }
}
