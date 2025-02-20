package br.com.start.medicare.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorAppointmentRequest {
    private Long patient;
    private Long doctor;
}
