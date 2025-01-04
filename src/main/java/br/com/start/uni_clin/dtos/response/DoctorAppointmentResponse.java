package br.com.start.uni_clin.dtos.response;

import java.time.LocalDateTime;

import br.com.start.uni_clin.entities.DoctorAppointment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorAppointmentResponse {
    
    private Long id;
    private String patient;
    private LocalDateTime date;
    private Long doctor;

    public DoctorAppointmentResponse(DoctorAppointment dto) {
        this.id = dto.getId();
        this.patient = dto.getPatient();
        this.date = dto.getDate();
        this.doctor = dto.getDoctor().getId();
    }
}
