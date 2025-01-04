package br.com.start.uni_clin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.uni_clin.dtos.request.DoctorAppointmentRequest;
import br.com.start.uni_clin.entities.DoctorAppointment;
import br.com.start.uni_clin.repositories.DoctorAppointmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorAppointmentService {
    
    @Autowired
    private DoctorAppointmentRepository doctorAppointmentRepository;

    public DoctorAppointment createDoctorAppointment(DoctorAppointmentRequest dto) {
        DoctorAppointment doctorAppointment = new DoctorAppointment(dto);

        return doctorAppointmentRepository.save(doctorAppointment);
    }
}
