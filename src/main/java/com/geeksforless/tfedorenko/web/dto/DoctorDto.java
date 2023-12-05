package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.persistence.type.DepartmentType;
import com.geeksforless.tfedorenko.persistence.type.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
    private DepartmentType departmentType;
    private List<AppointmentDto> appointments;

    public DoctorDto(Doctor doctor){
        this.id=doctor.getId();
        this.email = doctor.getEmail();
        this.firstName = doctor.getFirstname();
        this.lastName = doctor.getLastname();
        this.age = doctor.getAge();
        this.gender = doctor.getGender();
        this.departmentType = doctor.getDepartment();
        initAppointment(doctor);
    }

    private void initAppointment(Doctor doctor) {
        List<Appointment> doctorSet = doctor.getAppointments();
        if(CollectionUtils.isNotEmpty(doctorSet)){
            this.appointments= doctorSet.stream().map(AppointmentDto::new).collect(Collectors.toList());
        }
    }

}
