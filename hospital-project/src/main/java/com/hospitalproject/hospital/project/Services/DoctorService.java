package com.hospitalproject.hospital.project.Services;

import com.hospitalproject.hospital.project.Models.Doctor;
import com.hospitalproject.hospital.project.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public String register(Doctor doctor) {
        doctorRepository.save(doctor);
        return "doctor "+doctor.getName()+" has been registered";
    }
    public List<Doctor> getDoctors(){
        return null;
    }

}
