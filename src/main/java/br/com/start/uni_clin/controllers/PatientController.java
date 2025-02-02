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

import br.com.start.uni_clin.dtos.request.PatientRequest;
import br.com.start.uni_clin.dtos.response.PatientResponse;
import br.com.start.uni_clin.entities.Patient;
import br.com.start.uni_clin.services.PatientService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user/patient")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {
    
    @Autowired
    PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest dto) {

        Patient patient = patientService.createPatient(dto);

        return ResponseEntity.status(201).body(new PatientResponse(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {

        Patient entity = this.patientService.findPatientById(id);

        return ResponseEntity.ok(entity);
    }

    @PostMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> findPatientByName(@RequestBody PatientRequest dto) {

        return patientService.findPatientByName(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        
        List<Patient> patient = patientService.getAllPatients();

        return patient;
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Patient> updatePatientById(@PathVariable(value = "id") Long id, @RequestBody PatientRequest dto) {

        return patientService.updatePatientById(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatientById(@PathVariable("id") Long id) {

        return patientService.deletePatientById(id);
    }
}