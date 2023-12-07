package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor findByEmail(String email);

    void updateDoctor(Doctor doctor);

    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);

    void deactivateDoctor(Long id);

    void activateDoctor(Long id);

    void removeDoctor(Long id);

    void createDoctor(Doctor doctor);
}
