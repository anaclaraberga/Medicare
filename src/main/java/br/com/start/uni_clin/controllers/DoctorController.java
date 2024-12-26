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

import br.com.start.uni_clin.dtos.request.DoctorRequest;
import br.com.start.uni_clin.dtos.response.DoctorResponse;
import br.com.start.uni_clin.entities.Doctor;
import br.com.start.uni_clin.services.DoctorService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user/doctor")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoctorController {
    
    @Autowired
    DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorRequest dto) {

        Doctor doctor = doctorService.createDoctor(dto);

        return ResponseEntity.status(201).body(new DoctorResponse(doctor));
    }
}
