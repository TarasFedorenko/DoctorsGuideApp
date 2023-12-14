package com.geeksforless.tfedorenko.factory;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;

public class DoctorFactory {
    public static Doctor createTwoArgsDoctor(Long id, String email) {
        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setEmail(email);
        return doctor;
    }
}
