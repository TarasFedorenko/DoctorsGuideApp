package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Appointment;

public interface AppointmentService {
    void saveAppointment(Appointment newAppointment);
}
