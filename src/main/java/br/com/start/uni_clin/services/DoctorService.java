package br.com.start.uni_clin.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
