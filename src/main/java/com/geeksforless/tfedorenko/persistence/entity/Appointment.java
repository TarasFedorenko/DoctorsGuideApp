package com.geeksforless.tfedorenko.persistence.entity;

import com.geeksforless.tfedorenko.persistence.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name="appointments")
public class Appointment extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "birth_date")
    private Date birthDate;

    @Transient
    private Map<Long, Integer> drugQuantities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "drugs_appointment",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id") )
    private Set<Drug> drugs;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Appointment(){
        this.drugs=new HashSet<>();
        this.drugQuantities =new HashMap<>();
    }
}
