package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDto {

    private Long id;

    private Date created;

    private Date birthDate;

    private String firstName;

    private String lastName;

    private Set<DrugDto> drugs;

    public AppointmentDto(Appointment appointment){
        this.id = appointment.getId();
        this.created = appointment.getCreated();
        this.birthDate = appointment.getBirthDate();
        this.firstName = appointment.getFirstName();
        this.lastName = appointment.getLastName();
        initDrugs(appointment);
    }

    private void initDrugs(Appointment appointment) {
        Set<Drug> drugSet = appointment.getDrugs();
        if(CollectionUtils.isNotEmpty(drugSet)){
            this.drugs = drugSet.stream().map(DrugDto::new).collect(Collectors.toSet());
        }
    }


}
