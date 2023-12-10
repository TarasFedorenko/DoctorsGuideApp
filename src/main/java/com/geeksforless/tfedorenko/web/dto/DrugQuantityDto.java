package com.geeksforless.tfedorenko.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DrugQuantityDto {

    private String article;
    private Integer quantity;
}
