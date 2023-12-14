package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.persistence.repository.user.DoctorRepository;
import com.geeksforless.tfedorenko.web.dto.AuthDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrationServiceImplTest {
    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private RegistrationServiceImpl registrationService;
    public RegistrationServiceImplTest() {
        MockitoAnnotations.openMocks(this);
        registrationService = new RegistrationServiceImpl(doctorRepository, passwordEncoder);
    }

    @Test
    void testRegistration() {
        AuthDto authDto = new AuthDto();
        authDto.setEmail("test@example.com");
        authDto.setPassword("password123");

        when(doctorRepository.existsByEmail(authDto.getEmail())).thenReturn(false);
        when(passwordEncoder.encode(authDto.getPassword())).thenReturn("encodedPassword");

        registrationService.registration(authDto);

        verify(doctorRepository, times(1)).existsByEmail(authDto.getEmail());

        ArgumentCaptor<Doctor> doctorCaptor = ArgumentCaptor.forClass(Doctor.class);
        verify(doctorRepository, times(1)).save(doctorCaptor.capture());

        Doctor savedDoctor = doctorCaptor.getValue();
        assertEquals(authDto.getEmail(), savedDoctor.getEmail());
        assertEquals("encodedPassword", savedDoctor.getPassword());
    }
}