package br.com.start.uni_clin.dtos.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorAppointmentResponse {
    
    private Long id;
    private String patient;
    private LocalDateTime date;
    private String doctor;
}
