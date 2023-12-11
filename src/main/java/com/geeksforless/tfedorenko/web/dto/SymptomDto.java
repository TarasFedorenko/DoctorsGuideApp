package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SymptomDto {

    private Long id;
    private String name;

    public SymptomDto(Symptom symptom) {
        this.id = symptom.getId();
        this.name = symptom.getName();
    }
}
