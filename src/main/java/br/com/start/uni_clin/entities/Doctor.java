package br.com.start.uni_clin.entities;

import java.util.ArrayList;

import br.com.start.uni_clin.dtos.request.DoctorRequest;
import io.micrometer.common.lang.Nullable;
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

    public Doctor(DoctorRequest dto) {

        // ArrayList<String> array = new ArrayList<String>(dto.getCrm().length());

        // String state = array.get(0) + array.get(1);

        // array.remove(0);
        // array.remove(1);

        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
        this.crm = "CRM/" + dto.getCrm().toUpperCase();
        // this.crm = "CRM/" + state + " " + array;
    }
}
