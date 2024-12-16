package br.com.start.uni_clin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.uni_clin.entities.DoctorAppointment;

public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long>{
    
}
