package br.com.start.uni_clin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.uni_clin.dtos.request.DoctorAppointmentRequest;
import br.com.start.uni_clin.dtos.response.DoctorAppointmentResponse;
import br.com.start.uni_clin.entities.DoctorAppointment;
import br.com.start.uni_clin.services.DoctorAppointmentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/appointment")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoctorAppointmentController {
    
    @Autowired
    DoctorAppointmentService doctorAppointmentService;

    public DoctorAppointmentController(DoctorAppointmentService doctorAppointmentService) {
        this.doctorAppointmentService = doctorAppointmentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DoctorAppointmentResponse> createDoctorAppointment(@RequestBody DoctorAppointmentRequest dto) {
        DoctorAppointment doctorAppointment = doctorAppointmentService.createDoctorAppointment(dto);

        return ResponseEntity.status(201).body(new DoctorAppointmentResponse(doctorAppointment));
    }   
}
