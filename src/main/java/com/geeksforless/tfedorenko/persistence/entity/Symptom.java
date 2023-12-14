package com.geeksforless.tfedorenko.persistence.entity;

import com.geeksforless.tfedorenko.persistence.type.SymptomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "symptoms")
public class Symptom extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "symptom_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SymptomType type;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disease_symptom",
            joinColumns = @JoinColumn(name = "symptom_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    private Set<Disease> diseases;

    public Symptom() {
        super();
        this.diseases=new HashSet<>();
    }

}
