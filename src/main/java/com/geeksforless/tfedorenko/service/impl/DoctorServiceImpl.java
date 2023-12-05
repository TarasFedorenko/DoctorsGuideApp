package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.persistence.entity.user.User;
import com.geeksforless.tfedorenko.persistence.repository.user.DoctorRepository;
import com.geeksforless.tfedorenko.persistence.repository.user.UserRepository;
import com.geeksforless.tfedorenko.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    @Override
    public Doctor findByEmail(String email) {
        Optional<Doctor>doctorOptional = doctorRepository.findByEmail(email);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        }
        throw new RuntimeException("doctor not found");
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
}
