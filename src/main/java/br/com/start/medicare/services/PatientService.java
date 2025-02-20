package br.com.start.medicare.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.start.medicare.dtos.request.PatientRequest;
import br.com.start.medicare.entities.Patient;
import br.com.start.medicare.repositories.PatientRepository;
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

    public Patient findPatientById(Long id) {
        Optional<Patient> patient = this.patientRepository.findById(id);

        return patient.orElseThrow(() -> new ObjectNotFoundException("Doutor não encontrado! Id: " + id + "Tipo: " + Patient.class.getName(), patient));
    }

    public List<Patient> findPatientByName(PatientRequest dto) {
        List<Patient> patient = this.patientRepository.findByName(dto.getName());

        return patient;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public ResponseEntity<Patient> updatePatientById(PatientRequest dto, Long id) {
        return patientRepository.findById(id)
        .map( update -> {
            update.setEmail(dto.getEmail());
            update.setName(dto.getName());
            update.setPhone(dto.getPhone());
            update.setSurname(dto.getSurname());

            Patient updated = patientRepository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deletePatientById(Long id) {
        return patientRepository.findById(id)
        .map( delete -> {
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
