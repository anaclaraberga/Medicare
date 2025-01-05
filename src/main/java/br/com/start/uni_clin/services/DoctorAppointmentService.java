package br.com.start.uni_clin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.uni_clin.dtos.request.DoctorAppointmentRequest;
import br.com.start.uni_clin.entities.Doctor;
import br.com.start.uni_clin.entities.DoctorAppointment;
import br.com.start.uni_clin.entities.Patient;
import br.com.start.uni_clin.repositories.DoctorAppointmentRepository;
import br.com.start.uni_clin.repositories.DoctorRepository;
import br.com.start.uni_clin.repositories.PatientRepository;
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
            .orElseThrow(() -> new RuntimeException("Doctor not found."));

        Patient patient = patientRepository.findById(dto.getPatient())
            .orElseThrow(() -> new RuntimeException("Patient not found."));

        DoctorAppointment doctorAppointment = new DoctorAppointment(dto);

        doctorAppointment.setDoctor(doctor);
        doctorAppointment.setPatient(patient);

        return doctorAppointmentRepository.save(doctorAppointment);
    }
}
