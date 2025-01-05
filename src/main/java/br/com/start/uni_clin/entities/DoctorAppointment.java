package br.com.start.uni_clin.entities;

import java.time.LocalDateTime;

import br.com.start.uni_clin.dtos.request.DoctorAppointmentRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "doctor_appointment")
@Data
public class DoctorAppointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patients_id", referencedColumnName = "id")
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctors_id", referencedColumnName = "id")
    private Doctor doctor;

    public DoctorAppointment(DoctorAppointmentRequest dto) {
        this.date = LocalDateTime.now();
    }
}
