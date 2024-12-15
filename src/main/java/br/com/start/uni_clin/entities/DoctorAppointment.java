package br.com.start.uni_clin.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "doctor-appointment")
@Data
public class DoctorAppointment {
    
    private Long id;
    private String patient;
    private LocalDateTime date;
    private Doctor doctor;
}
