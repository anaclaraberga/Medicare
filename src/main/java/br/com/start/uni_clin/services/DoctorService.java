package br.com.start.uni_clin.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.start.uni_clin.dtos.request.DoctorRequest;
import br.com.start.uni_clin.entities.Doctor;
import br.com.start.uni_clin.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(DoctorRequest dto) {
        Doctor entity = new Doctor(dto);

        return doctorRepository.save(entity);
    }

    public Doctor findDoctorById(Long id) {
        Optional<Doctor> doctor = this.doctorRepository.findById(id);

        return doctor.orElseThrow(() -> new ObjectNotFoundException("Doutor não encontrado! Id: " + id + "Tipo: " + Doctor.class.getName(), doctor));
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public ResponseEntity<Doctor> updateDoctorById(DoctorRequest dto, Long id) {
        return doctorRepository.findById(id)
        .map( update -> {
            update.setCrm(dto.getCrm());
            update.setEmail(dto.getEmail());
            update.setName(dto.getName());
            update.setPhone(dto.getPhone());

            Doctor updated = doctorRepository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteDoctorById(Long id) {
        return doctorRepository.findById(id)
        .map( delete -> {
            doctorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
