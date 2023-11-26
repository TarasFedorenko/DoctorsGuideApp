package com.geeksforless.tfedorenko.web.dto.detail;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProcedureDetailDto {

    private Long id;
    private String name;
    private ProcedureType procedureType;
    private Set<DiseaseDto> diseases;

    public ProcedureDetailDto(Procedure procedure){
        this.id =procedure.getId();
        this.name =procedure.getName();
        this.procedureType =procedure.getProcedureType();
        initDiseases(procedure);

    }

    private void initDiseases(Procedure procedure) {
        Set<Disease> diseaseSet =procedure.getDiseases();
        if(CollectionUtils.isNotEmpty(diseaseSet)){
            this.diseases = diseaseSet.stream().map(DiseaseDto::new).collect(Collectors.toSet());
        }
    }
}
