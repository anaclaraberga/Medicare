package br.com.start.medicare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.start.medicare.entities.DoctorAppointment;

@Repository
public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment, Long>{
    
}
