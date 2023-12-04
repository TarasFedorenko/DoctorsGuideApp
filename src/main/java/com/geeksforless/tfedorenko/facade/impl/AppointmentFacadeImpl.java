package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.AppointmentFacade;
import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.entity.user.User;
import com.geeksforless.tfedorenko.service.AppointmentService;
import com.geeksforless.tfedorenko.service.DoctorService;
import com.geeksforless.tfedorenko.service.DrugService;
import com.geeksforless.tfedorenko.util.SecurityUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class AppointmentFacadeImpl implements AppointmentFacade {

    private final DrugService drugService;

    private final AppointmentService appointmentService;

    private final DoctorService doctorService;

    @PersistenceContext
    private EntityManager entityManager;

    private final Set<Drug> temporaryDrugs = new HashSet<>();

    private static final String DIRECTORY_PATH = "appointments";

    private static final String FILE_NAME_PREFIX = "appointment";

    @Override
    public void addDrugToAppointment(Long id) {
        Optional<Drug> optionalDrug = drugService.findById(id);
        if (optionalDrug.isPresent()) {
            Drug drugToAdd = optionalDrug.get();
            if (!temporaryDrugs.contains(drugToAdd)) {
                temporaryDrugs.add(drugToAdd);
            } else {
                throw new RuntimeException("Drug is already in the list");
            }
        } else {
            throw new RuntimeException("Drug not found");
        }
    }
    @Override
    @Transactional
    public void saveAppointment(Appointment newAppointment) {
        List<Long> drugIds = convertSetToDrugIds(temporaryDrugs);
        List<Drug> drugs = drugService.findAllByIds(drugIds);


        Map<Long, Integer> drugQuantities = newAppointment.getDrugQuantities();
        for (Drug drug : drugs) {
            int orderedQuantity = drugQuantities.getOrDefault(drug.getId(), 0);
            if (orderedQuantity > drug.getQuantity()) {
                throw new RuntimeException("Ordered quantity exceeds available quantity for drug: " + drug.getName());
            }
        }

        for (Drug drug : drugs) {
            int orderedQuantity = drugQuantities.getOrDefault(drug.getId(), 0);

            int updatedQuantity = drug.getQuantity() - orderedQuantity;
            drug.setQuantity(updatedQuantity);
            drugService.saveDrug(drug);
        }

        newAppointment.getDrugs().addAll(drugs);
        User user = doctorService.findByEmail(SecurityUtil.getUsername());
        newAppointment.setUser(user);

        appointmentService.saveAppointment(newAppointment);
        saveAppointmentToFile(newAppointment);
        clearTemporaryList();
    }

    @Override
    public void removeDrugFromAppointment(Long drugId) {
        temporaryDrugs.removeIf(drug -> Objects.equals(drug.getId(), drugId));
    }

    @Override
    public Set<Drug> getTemporaryDrugs() {
        return temporaryDrugs;
    }

    private void clearTemporaryList() {
        temporaryDrugs.clear();
    }

    private List<Long> convertSetToDrugIds(Set<Drug> temporaryDrugs) {
        return temporaryDrugs.stream()
                .map(Drug::getId)
                .collect(Collectors.toList());
    }
    public void saveAppointmentToFile(Appointment appointment) {
        try {
            Path directoryPath = Paths.get(DIRECTORY_PATH);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
            String fileName = generateFileName(appointment.getId());
            Path filePath = directoryPath.resolve(fileName);

            String formattedText = String.format("Призначення видане %s пацієнту %s %s %s р.н.\nПрепарати:\n",
                    appointment.getCreated(),
                    appointment.getFirstName(),
                    appointment.getLastName(),
                    appointment.getBirthDate());
            for (Drug drug : appointment.getDrugs()) {
                int orderedQuantity = appointment.getDrugQuantities().getOrDefault(drug.getId(), 0);
                formattedText += String.format("%s: %d\n", drug.getName(), orderedQuantity);
            }
            Files.write(filePath, formattedText.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateFileName(long appointmentId) {
        return FILE_NAME_PREFIX + appointmentId + ".txt";
    }
}
