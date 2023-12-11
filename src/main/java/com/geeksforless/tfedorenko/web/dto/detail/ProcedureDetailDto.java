package com.geeksforless.tfedorenko.web.dto.detail;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.ProcedureDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ProcedureDetailDto extends ProcedureDto {

    private ProcedureType procedureType;
    private Set<DiseaseDto> diseases;

    public ProcedureDetailDto(Procedure procedure) {
        super();
        this.procedureType = procedure.getProcedureType();
        initDiseases(procedure);
    }

    private void initDiseases(Procedure procedure) {
        Set<Disease> diseaseSet = procedure.getDiseases();
        if (CollectionUtils.isNotEmpty(diseaseSet)) {
            this.diseases = diseaseSet.stream().map(DiseaseDto::new).collect(Collectors.toSet());
        }
    }
}
