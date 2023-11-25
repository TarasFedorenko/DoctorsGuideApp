package com.geeksforless.tfedorenko.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="doses")
public class Dose extends BaseEntity{
    @Column(name = "value", nullable = false, precision = 8, scale = 4)
    private Double value;
    @Column(name="unit", nullable = false)
    private String unit;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id", referencedColumnName = "id")
    private Drug drug;
}
