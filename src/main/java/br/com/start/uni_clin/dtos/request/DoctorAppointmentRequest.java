package br.com.start.uni_clin.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorAppointmentRequest {
    private String patient;
    private String doctor;
}
