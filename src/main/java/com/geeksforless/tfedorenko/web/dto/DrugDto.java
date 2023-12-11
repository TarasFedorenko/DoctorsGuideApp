package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.type.DrugGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DrugDto {
    private Long id;
    private String name;
    private Date created;
    private String article;
    private DrugGroup drugGroup;
    private Integer quantity;

    public DrugDto(Drug drug){
        this.id= drug.getId();
        this.name = drug.getName();
        this.article = drug.getArticle();
        this.drugGroup =drug.getDrugGroup();
        this.quantity = drug.getQuantity();
        this.created =drug.getCreated();
    }
}
