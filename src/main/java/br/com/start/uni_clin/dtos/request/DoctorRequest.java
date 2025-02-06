package br.com.start.uni_clin.dtos.request;

import br.com.start.uni_clin.enums.MedicalSpecialty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRequest {
    private String name;
    private String email;
    private String phone;
    private String crm;
    private MedicalSpecialty specialty;
}
