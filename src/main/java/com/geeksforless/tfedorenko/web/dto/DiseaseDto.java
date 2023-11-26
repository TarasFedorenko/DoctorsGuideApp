package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiseaseDto {
    private Long id;
    private String name;

    public DiseaseDto(Disease disease){
        this.id = disease.getId();
        this.name = disease.getName();
    }

}
