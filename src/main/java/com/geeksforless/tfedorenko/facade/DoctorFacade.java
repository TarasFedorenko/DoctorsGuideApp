package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.web.dto.DoctorDto;


public interface DoctorFacade {


    void updateDoctor(Doctor updatedDoctor);

    Doctor findByEmail(String email);
}
