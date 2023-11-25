package com.geeksforless.tfedorenko.persistence.entity;

import com.geeksforless.tfedorenko.persistence.type.ProcedureType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "procedures")
public class Procedure extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "procedure_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProcedureType procedureType;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disease_procedure",
            joinColumns = @JoinColumn(name = "procedure_id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id"))
    private Set<Disease> diseases;

    public Procedure() {
        super();
        this.diseases = new HashSet<>();
    }
}
