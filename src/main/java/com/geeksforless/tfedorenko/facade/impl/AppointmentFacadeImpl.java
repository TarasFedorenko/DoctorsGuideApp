package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.AppointmentFacade;
import com.geeksforless.tfedorenko.persistence.entity.Dose;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.service.DrugService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class AppointmentFacadeImpl implements AppointmentFacade {

    private final DrugService drugService;

    private final List<Drug> temporaryDrugs = new ArrayList<>();
    @Override
    public void addDrugToAppointment(Long id, Long doseId) {
        Drug drugToAdd = drugService.findById(id).get();
        Dose selectedDose = drugToAdd.getDoses().stream()
                .filter(dose -> dose.getId().equals(doseId))
                .findFirst()
                .orElse(null);

        if (selectedDose != null) {
            Drug temporaryDrug = new Drug();
            temporaryDrug.setName(drugToAdd.getName());
            temporaryDrug.setQuantity(1);

            Dose temporaryDose = new Dose();
            temporaryDose.setValue(selectedDose.getValue());
            temporaryDose.setUnit(selectedDose.getUnit());

            temporaryDrug.setDoses(Collections.singleton(temporaryDose));

            temporaryDrugs.add(temporaryDrug);
        }
    }
}
