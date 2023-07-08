package com.hospitalproject.hospital.project.Controllers;

import com.hospitalproject.hospital.project.Models.Patient;
import com.hospitalproject.hospital.project.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/register")
    public String addPatient(@RequestBody Patient patient){
        String res = patientService.register(patient);
        return res;
    }
}
