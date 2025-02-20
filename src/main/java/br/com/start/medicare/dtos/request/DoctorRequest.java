package br.com.start.medicare.dtos.request;

import br.com.start.medicare.enums.MedicalSpecialty;
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
