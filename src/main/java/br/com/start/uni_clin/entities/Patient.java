package br.com.start.uni_clin.entities;

import br.com.start.uni_clin.dtos.request.PatientRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 11)
    private String phone;

    public Patient(PatientRequest dto) {
        this.name = dto.getName();
        this.surname = dto.getSurname();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
    }
}
