package br.com.start.medicare.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
}
