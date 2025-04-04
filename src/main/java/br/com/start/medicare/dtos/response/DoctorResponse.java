package br.com.start.medicare.dtos.response;
import br.com.start.medicare.entities.Doctor;
import br.com.start.medicare.enums.MedicalSpecialty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    private MedicalSpecialty specialty;

    public DoctorResponse(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.email = doctor.getEmail();
        this.phone = doctor.getPhone();
        this.crm = doctor.getCrm();
        this.specialty = doctor.getSpecialty();
    }
}
