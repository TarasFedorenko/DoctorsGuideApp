package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.type.DiseaseClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DiseaseDto {
    private Long id;
    private String name;
    private DiseaseClass diseaseClass;

    public DiseaseDto(Disease disease) {
        this.id = disease.getId();
        this.name = disease.getName();
        this.diseaseClass = disease.getDiseaseClass();
    }

}
