package br.com.start.medicare.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.start.medicare.dtos.request.DoctorAppointmentRequest;
import br.com.start.medicare.entities.Doctor;
import br.com.start.medicare.entities.DoctorAppointment;
import br.com.start.medicare.entities.Patient;
import br.com.start.medicare.repositories.DoctorAppointmentRepository;
import br.com.start.medicare.repositories.DoctorRepository;
import br.com.start.medicare.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorAppointmentService {
    
    @Autowired
    private DoctorAppointmentRepository doctorAppointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public DoctorAppointment createDoctorAppointment(DoctorAppointmentRequest dto) {
        Doctor doctor = doctorRepository.findById(dto.getDoctor())
            .orElseThrow(() -> new RuntimeException("Doctor not found. Please, try again with a different ID number."));

        Patient patient = patientRepository.findById(dto.getPatient())
            .orElseThrow(() -> new RuntimeException("Patient not found. Please, try again with a different ID number."));

        DoctorAppointment doctorAppointment = new DoctorAppointment(dto);

        doctorAppointment.setDoctor(doctor);
        doctorAppointment.setPatient(patient);

        return doctorAppointmentRepository.save(doctorAppointment);
    }

    public DoctorAppointment findDoctorAppointmentById(Long id) {
        Optional<DoctorAppointment> doctorAppointment = this.doctorAppointmentRepository.findById(id);

        return doctorAppointment.orElseThrow(() -> new ObjectNotFoundException("Doctor appointment not found! Id: " + id + "Type: " + DoctorAppointment.class.getName(), doctorAppointment));
    }

    public List<DoctorAppointment> getAllDoctorAppointments() {
        return doctorAppointmentRepository.findAll();
    }

    public ResponseEntity<DoctorAppointment> updateDoctorAppointmentById(DoctorAppointmentRequest dto, Long id) {
        return doctorAppointmentRepository.findById(id)
        .map(update -> {
            update.getDate();

            DoctorAppointment updated = doctorAppointmentRepository.save(update);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteDoctorAppointmentById(Long id) {
        return doctorAppointmentRepository.findById(id)
        .map( delete -> {
            doctorAppointmentRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
