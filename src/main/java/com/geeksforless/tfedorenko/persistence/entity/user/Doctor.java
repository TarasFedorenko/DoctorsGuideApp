package com.geeksforless.tfedorenko.persistence.entity.user;

import com.geeksforless.tfedorenko.persistence.type.DepartmentType;
import com.geeksforless.tfedorenko.persistence.type.Gender;
import com.geeksforless.tfedorenko.persistence.type.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("DOCTOR")
public class Doctor extends User{
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    @Column(name = "department")
    @Enumerated(value = EnumType.STRING)
    private DepartmentType department;

    public Doctor(){
        super();
        setRoleType(RoleType.ROLE_DOCTOR);
    }


}
