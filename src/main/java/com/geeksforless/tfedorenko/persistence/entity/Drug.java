package com.geeksforless.tfedorenko.persistence.entity;

import com.geeksforless.tfedorenko.persistence.type.DrugGroup;
import groovy.transform.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "drugs")
public class Drug extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description",  columnDefinition = "TEXT")
    private String description;
    @Column(name = "article")
    private String article;
    @Column(name = "dose_value", precision = 10, scale = 2)
    private double doseValue;
    @Column(name = "dose_unit")
    private String doseUnit;
    @Column(name = "drug_group")
    @Enumerated(EnumType.STRING)
    private DrugGroup drugGroup;



    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "analog_drug",
            joinColumns = @JoinColumn(name = "drug_id"),
            inverseJoinColumns = @JoinColumn(name = "analog_id"))
    private Set<Drug> analogs;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "disease_drug",
            joinColumns = @JoinColumn(name = "disease_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_id"))
    private Set<Disease> diseases;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "drugs", cascade = CascadeType.ALL)
    private Set<Appointment>appointments;


    public Drug(){
        super();
        this.analogs = new HashSet<>();
        this.diseases = new HashSet<>();
        this.quantity = 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return Objects.equals(getId(), drug.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
