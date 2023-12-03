package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;

public interface DoctorService {
    Doctor findByEmail(String email);
}
