package com.geeksforless.tfedorenko.web.dto;

import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcedureDto {

    private Long id;
     private String name;

     public ProcedureDto(Procedure procedure){
         this.id = procedure.getId();
         this.name = procedure.getName();
     }

}
