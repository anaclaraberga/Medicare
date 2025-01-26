package br.com.start.uni_clin.controllers;

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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody DoctorRequest dto) {

        Doctor doctor = doctorService.createDoctor(dto);

        return ResponseEntity.status(201).body(new DoctorResponse(doctor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findDoctorById(@PathVariable Long id) {

        Doctor entity = this.doctorService.findDoctorById(id);

        return ResponseEntity.ok(entity);
    }

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> findDoctorByName(@RequestBody DoctorRequest dto) {

        List<Doctor> entity = this.doctorService.findDoctorByName(dto.getName());

        return entity;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getAllDoctors() {
        
        List<Doctor> doctor = doctorService.getAllDoctors();

        return doctor;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Doctor> updateDoctorById(@PathVariable(value = "id") Long id, @RequestBody DoctorRequest dto) {

        return doctorService.updateDoctorById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDoctorById(@PathVariable("id") Long id) {

        return doctorService.deleteDoctorById(id);
    }
}