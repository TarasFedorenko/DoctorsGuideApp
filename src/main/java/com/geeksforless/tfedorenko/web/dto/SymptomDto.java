package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomDto {

    private Long id;
    private String name;

    public SymptomDto(Symptom symptom) {
        this.id = symptom.getId();
        this.name = symptom.getName();
    }
}
