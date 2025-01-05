package br.com.start.uni_clin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.uni_clin.dtos.request.PatientRequest;
import br.com.start.uni_clin.entities.Patient;
import br.com.start.uni_clin.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(PatientRequest dto) {

        Patient entity = new Patient(dto);

        return patientRepository.save(entity);
    }
}
