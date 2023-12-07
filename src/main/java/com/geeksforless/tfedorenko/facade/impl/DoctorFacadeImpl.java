package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.DoctorFacade;
import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.service.DoctorService;
import com.geeksforless.tfedorenko.web.dto.DoctorDto;
import com.geeksforless.tfedorenko.web.dto.detail.DoctorDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<DoctorDto> getAllDoctors() {
        return doctorService.findAll().stream().map(DoctorDto::new).collect(Collectors.toList());
    }

    @Override
    public DoctorDetailDto getDoctor(Long id) {
        Optional<Doctor> optionalDoctor =doctorService.findById(id);
        return optionalDoctor.map(DoctorDetailDto::new).orElseThrow(()->new RuntimeException("doctor not found"));
    }

    @Override
    public void deactivateDoctor(Long id) {
        doctorService.deactivateDoctor(id);
    }

    @Override
    public void activateDoctor(Long id) {
        doctorService.activateDoctor(id);
    }

    @Override
    public void removeDoctor(Long id) {
        doctorService.removeDoctor(id);
    }

    @Override
    public void createDoctor(Doctor doctor) {
        doctorService.createDoctor(doctor);
    }
}
