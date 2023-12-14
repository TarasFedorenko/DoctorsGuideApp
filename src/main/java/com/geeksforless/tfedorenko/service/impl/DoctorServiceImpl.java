package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.persistence.repository.user.DoctorRepository;
import com.geeksforless.tfedorenko.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    public Doctor findByEmail(String email) {
        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(email);
        if (doctorOptional.isPresent()) {
            return doctorOptional.get();
        }
        throw new RuntimeException("doctor not found");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void deactivateDoctor(Long id) {
        Doctor doctor = findById(id).orElseThrow(() -> new RuntimeException("doctor not found"));
        doctor.setEnable(false);
        doctorRepository.save(doctor);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void activateDoctor(Long id) {
        Doctor doctor = findById(id).orElseThrow(() -> new RuntimeException("doctor not found"));
        doctor.setEnable(true);
        doctorRepository.save(doctor);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void removeDoctor(Long id) {
        Doctor doctor = findById(id).orElseThrow(() -> new RuntimeException("doctor not found"));
        doctorRepository.delete(doctor);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void createDoctor(Doctor doctor) {
        String encodedPass = encoder.encode(doctor.getPassword());
        doctor.setPassword(encodedPass);
        doctorRepository.save(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return doctorRepository.existsByEmail(email);
    }
}
