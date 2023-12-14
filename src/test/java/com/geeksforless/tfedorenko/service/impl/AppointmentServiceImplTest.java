package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.repository.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AppointmentServiceImplTest {
    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentServiceImpl yourService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveAppointment() {
        Appointment newAppointment = new Appointment();
        newAppointment.setId(1L);
        yourService.saveAppointment(newAppointment);
        verify(appointmentRepository, times(1)).save(newAppointment);
    }
}