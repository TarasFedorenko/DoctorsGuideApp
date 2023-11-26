package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Drug;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrugDto {
    private Long id;
    private String name;

    public DrugDto(Drug drug){
        this.id= drug.getId();
        this.name = drug.getName();
    }
}
