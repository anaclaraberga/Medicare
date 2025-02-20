package br.com.start.medicare.dtos.response;

import java.time.LocalDateTime;

import br.com.start.medicare.entities.DoctorAppointment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorAppointmentResponse {
    
    private Long id;
    private Long patient;
    private LocalDateTime date;
    private Long doctor;

    public DoctorAppointmentResponse(DoctorAppointment dto) {
        this.id = dto.getId();
        this.patient = dto.getPatient().getId();
        this.date = dto.getDate();
        this.doctor = dto.getDoctor().getId();
    }
}
