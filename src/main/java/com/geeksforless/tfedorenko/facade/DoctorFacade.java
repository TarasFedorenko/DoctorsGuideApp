package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.web.dto.DoctorDto;
import com.geeksforless.tfedorenko.web.dto.detail.DoctorDetailDto;

import java.util.List;


public interface DoctorFacade {


    void updateDoctor(Doctor updatedDoctor);

    Doctor findByEmail(String email);

    List<DoctorDto> getAllDoctors();

    DoctorDetailDto getDoctor(Long id);

    void deactivateDoctor(Long id);

    void activateDoctor(Long id);

    void removeDoctor(Long id);

    void createDoctor(Doctor doctor);
}
