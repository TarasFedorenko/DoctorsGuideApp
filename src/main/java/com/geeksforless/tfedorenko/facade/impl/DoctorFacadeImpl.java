package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.DoctorFacade;
import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorFacadeImpl implements DoctorFacade {

    private final DoctorService doctorService;
    @Override
    public void updateDoctor(Doctor updatedDoctor) {
        doctorService.updateDoctor(updatedDoctor);
    }

    @Override
    public Doctor findByEmail(String email) {
        return doctorService.findByEmail(email);
    }
}
