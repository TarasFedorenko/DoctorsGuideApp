package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.factory.DoctorFactory;
import com.geeksforless.tfedorenko.factory.DrugFactory;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.repository.user.DoctorRepository;
import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoctorServiceImplTest {
    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private BCryptPasswordEncoder encoder;
    @InjectMocks
    private DoctorServiceImpl doctorService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByEmail() {
        String doctorEmail = "test@example.com";

        Doctor mockDoctor = new Doctor();
        mockDoctor.setId(1L);
        mockDoctor.setEmail(doctorEmail);
        mockDoctor.setPassword("password");

        when(doctorRepository.findByEmail(doctorEmail)).thenReturn(Optional.of(mockDoctor));

        Doctor result = doctorService.findByEmail(doctorEmail);
        assertEquals(mockDoctor, result);
        verify(doctorRepository, times(1)).findByEmail(doctorEmail);
    }

    @Test
    void testUpdateDoctor() {
        Doctor doctorToUpdate = new Doctor();
        doctorToUpdate.setId(1L);
        doctorToUpdate.setEmail("test@example.com");
        doctorToUpdate.setPassword("newPassword");

        doctorService.updateDoctor(doctorToUpdate);
        verify(doctorRepository, times(1)).save(doctorToUpdate);
    }

    void testFindAll() {
        List<Doctor> expectedDoctor = Arrays.asList(
                DoctorFactory.createTwoArgsDoctor(1L, "doctor1@mail.com"),
                DoctorFactory.createTwoArgsDoctor(2L, "doctor2@mail.com"),
                DoctorFactory.createTwoArgsDoctor(3L, "doctor3@mail.com"));

        when(doctorRepository.findAll()).thenReturn(expectedDoctor);
        List<Doctor> result = doctorService.findAll();
        assertEquals(expectedDoctor.size(), result.size());
        assertEquals(expectedDoctor, result);
        verify(doctorRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Doctor expectedDoctor = new Doctor();
        expectedDoctor.setId(1L);
        expectedDoctor.setEmail("test@mail.com");

        when(doctorRepository.findById(1L)).thenReturn(Optional.of(expectedDoctor));
        Optional<Doctor> result = doctorService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedDoctor, result.get());

        verify(doctorRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeactivateDoctor() {
        Long doctorId = 1L;
        Doctor mockDoctor = new Doctor();
        mockDoctor.setId(doctorId);
        mockDoctor.setEmail("test@example.com");
        mockDoctor.setPassword("password");
        mockDoctor.setEnable(true);

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(mockDoctor));
        doctorService.deactivateDoctor(doctorId);
        verify(doctorRepository, times(1)).findById(doctorId);
        assertFalse(mockDoctor.getEnable());
        verify(doctorRepository, times(1)).save(mockDoctor);
    }

    @Test
    public void testActivateDoctor() {
        Long doctorId = 1L;

        Doctor mockDoctor = new Doctor();
        mockDoctor.setId(doctorId);
        mockDoctor.setEmail("test@example.com");
        mockDoctor.setPassword("password");
        mockDoctor.setEnable(false);

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(mockDoctor));
        doctorService.activateDoctor(doctorId);
        verify(doctorRepository, times(1)).findById(doctorId);

        assertTrue(mockDoctor.getEnable());

        verify(doctorRepository, times(1)).save(mockDoctor);
    }


    @Test
    public void testRemoveDoctor() {
        Long doctorId = 1L;

        Doctor mockDoctor = new Doctor();
        mockDoctor.setId(doctorId);
        mockDoctor.setEmail("test@example.com");
        mockDoctor.setPassword("password");

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(mockDoctor));
        doctorService.removeDoctor(doctorId);
        verify(doctorRepository, times(1)).findById(doctorId);

        verify(doctorRepository, times(1)).delete(mockDoctor);
    }

    @Test
    public void testCreateDoctor() {
        Doctor doctorToCreate = new Doctor();
        doctorToCreate.setId(1L);
        doctorToCreate.setEmail("test@example.com");
        doctorToCreate.setPassword("password");

        when(encoder.encode("password")).thenReturn("encodedPassword");
        doctorService.createDoctor(doctorToCreate);
        verify(encoder, times(1)).encode("password");
        verify(doctorRepository, times(1)).save(doctorToCreate);
        assertEquals("encodedPassword", doctorToCreate.getPassword());
    }

    @Test
    public void testExistsByEmail() {
        String existingEmail = "test@example.com";
        String nonExistentEmail = "nonexistent@example.com";

        when(doctorRepository.existsByEmail(existingEmail)).thenReturn(true);
        when(doctorRepository.existsByEmail(nonExistentEmail)).thenReturn(false);
        assertTrue(doctorService.existsByEmail(existingEmail));
        assertFalse(doctorService.existsByEmail(nonExistentEmail));
        verify(doctorRepository, times(1)).existsByEmail(existingEmail);
        verify(doctorRepository, times(1)).existsByEmail(nonExistentEmail);
    }
}