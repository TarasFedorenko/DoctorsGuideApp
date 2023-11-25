package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.persistence.repository.user.DoctorRepository;
import com.geeksforless.tfedorenko.service.RegistrationService;
import com.geeksforless.tfedorenko.web.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final DoctorRepository doctorRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public void registration(AuthDto authDto) {
        if(doctorRepository.existsByEmail(authDto.getEmail())){
            throw new RuntimeException("user already exist");
        }
        Doctor doctor = new Doctor();
        doctor.setEmail(authDto.getEmail());
        doctor.setPassword(passwordEncoder.encode(authDto.getPassword()));
        doctorRepository.save(doctor);
    }
}
