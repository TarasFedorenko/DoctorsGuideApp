package com.geeksforless.tfedorenko.persistence.entity;

import com.geeksforless.tfedorenko.persistence.type.DiseaseClass;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "diseases")
public class Disease extends BaseEntity{
    @Column(name="name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name="disease_class")
    private DiseaseClass diseaseClass;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "diseases")
    private Set<Symptom> symptoms;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "diseases")
    private Set<Procedure> procedures;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "diseases")
    private Set<Drug> drugs;

    public Disease (){
        super();
        this.symptoms = new HashSet<>();
        this.procedures = new HashSet<>();
        this.drugs = new HashSet<>();
    }


}
