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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_appointment")
@Getter
@Setter
@NoArgsConstructor
public class DoctorAppointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime date;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    public DoctorAppointment(DoctorAppointmentRequest dto) {
        this.date = LocalDateTime.now();
    }
}
