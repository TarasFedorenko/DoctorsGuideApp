package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.repository.AppointmentRepository;
import com.geeksforless.tfedorenko.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void saveAppointment(Appointment newAppointment) {
        appointmentRepository.save(newAppointment);
    }
}
