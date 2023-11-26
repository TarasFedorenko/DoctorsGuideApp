package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Dose;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoseDto {

    private Long id;
    private Double value;
    private String unit;

    public DoseDto(Dose dose){
        this.id = dose.getId();
        this.value = dose.getValue();
        this.unit = dose.getUnit();
    }
}
