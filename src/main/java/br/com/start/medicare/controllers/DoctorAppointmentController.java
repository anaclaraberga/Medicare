package br.com.start.medicare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.medicare.dtos.request.DoctorAppointmentRequest;
import br.com.start.medicare.dtos.response.DoctorAppointmentResponse;
import br.com.start.medicare.entities.DoctorAppointment;
import br.com.start.medicare.services.DoctorAppointmentService;
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

    @GetMapping("/{id}")
    public ResponseEntity<DoctorAppointment> findDoctorAppointmentById(@PathVariable Long id) {

        DoctorAppointment entity = this.doctorAppointmentService.findDoctorAppointmentById(id);

        return ResponseEntity.ok(entity);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorAppointment> findAllDoctorsAppointment() {

        List<DoctorAppointment> doctorAppointments = doctorAppointmentService.getAllDoctorAppointments();

        return doctorAppointments;
    } 

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<DoctorAppointment> updateDoctorAppointmentById(@PathVariable (value = "id") Long id, @RequestBody DoctorAppointmentRequest dto) {

        return doctorAppointmentService.updateDoctorAppointmentById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> updateDoctorAppointmentById(@PathVariable("id") Long id) {

        return doctorAppointmentService.deleteDoctorAppointmentById(id);
    }
}
