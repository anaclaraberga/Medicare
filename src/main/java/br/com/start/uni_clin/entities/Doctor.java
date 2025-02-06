package br.com.start.uni_clin.entities;

import br.com.start.uni_clin.dtos.request.DoctorRequest;
import br.com.start.uni_clin.enums.MedicalSpecialty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 11)
    private String phone;

    @Column(nullable = false, length = 13)
    private String crm;

    @Column(nullable = false)
    private MedicalSpecialty specialty;

    public Doctor(DoctorRequest dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.crm = "CRM/" + dto.getCrm().toUpperCase();
        this.specialty = dto.getSpecialty();
    }
}
