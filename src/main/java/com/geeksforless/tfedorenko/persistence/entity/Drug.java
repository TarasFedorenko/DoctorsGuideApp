package com.geeksforless.tfedorenko.persistence.entity;

import com.geeksforless.tfedorenko.persistence.type.DrugGroup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "drugs")
public class Drug extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(name = "article", nullable = false)
    private String article;
    @Column(name = "drug_group", nullable = false)
    @Enumerated(EnumType.STRING)
    private DrugGroup drugGroup;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "analog_drug",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "analog_id"))
    private Set<Drug> analogs;
    @OneToMany(mappedBy = "drug")
    private Set<Dose> doses;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disease_drug",
            joinColumns = @JoinColumn(name = "disease_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id"))
    private Set<Disease> diseases;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "drugs")
    private Set<Appointment>appointments;


    public Drug(){
        super();
        this.analogs = new HashSet<>();
        this.doses = new HashSet<>();
        this.diseases = new HashSet<>();
        this.quantity = 0;
    }
}
