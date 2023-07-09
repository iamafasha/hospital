package com.hospitalproject.hospital.project.Controllers;

import com.hospitalproject.hospital.project.DTOs.AppointmentDto;
import com.hospitalproject.hospital.project.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/create")
    public String bookAppointment(@RequestBody AppointmentDto appointmentDto){
    String res = appointmentService.bookAppointment(appointmentDto);
    return res;
    }

    //this API endpoint is not of help
    @PostMapping("/assign-appointment")
    public String assignAppointment(@RequestParam int appId, @RequestParam int patientId ,@RequestParam int docId){
        String res = appointmentService.assignAppointment(appId, patientId, docId);
        return res;
    }
}
