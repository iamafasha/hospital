package com.hospitalproject.hospital.project.Controllers;

import com.hospitalproject.hospital.project.Models.Appointment;
import com.hospitalproject.hospital.project.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/create")
    public String bookAppointment(@RequestBody Appointment appointment){
    String res = appointmentService.bookAppointment(appointment);
    return res;
    }

    @PostMapping("/assign-appointment")
    public String assignAppointment(@RequestParam int appId, @RequestParam int patientId ,@RequestParam int docId){
        String res = appointmentService.assignAppointment(appId, patientId, docId);
        return res;
    }
}
