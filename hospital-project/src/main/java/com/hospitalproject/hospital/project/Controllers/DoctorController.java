package com.hospitalproject.hospital.project.Controllers;

import com.hospitalproject.hospital.project.Models.Doctor;
import com.hospitalproject.hospital.project.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor") // optional
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/register")
    public String register(@RequestBody Doctor doctor){
        String res = doctorService.register(doctor);
        return res;
    }
    @GetMapping("/get-doctors")
    public List<Doctor> getDoctors(){
        return null;
    }
}
