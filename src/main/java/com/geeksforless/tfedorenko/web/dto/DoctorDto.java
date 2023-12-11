package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto {

    private Long id;
    private Date created;
    private boolean isActive;
    private String email;
    private String firstName;
    private String lastName;

    public DoctorDto(Doctor doctor) {
        this.id = doctor.getId();
        this.created = doctor.getCreated();
        this.isActive = doctor.getEnable();
        this.email = doctor.getEmail();
        this.firstName = doctor.getFirstname();
        this.lastName = doctor.getLastname();
    }
}
