package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.entity.Drug;

import java.util.List;
import java.util.Set;

public interface AppointmentFacade {

    void addDrugToAppointment(Long id);

    Set<Drug> getTemporaryDrugs();

    void saveAppointment(Appointment newAppointment);
}
