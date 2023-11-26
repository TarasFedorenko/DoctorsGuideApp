package com.geeksforless.tfedorenko.persistence.entity.user;

import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.entity.BaseEntity;
import com.geeksforless.tfedorenko.persistence.type.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "role_type",nullable = false)
    private RoleType roleType;
    @Column(name = "enable",nullable = false)
    private Boolean enable;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

    public User (){
        super();
        this.enable =true;
        this.appointments=new HashSet<>();
    }

}
