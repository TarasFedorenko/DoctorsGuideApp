package com.geeksforless.tfedorenko.web.dto.detail;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.DiseaseClass;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.ProcedureDto;
import com.geeksforless.tfedorenko.web.dto.SymptomDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DiseaseDetailDto {

    private Long id;
    private String name;
    private DiseaseClass diseaseClass;
    private Set<SymptomDto> symptoms;
    private Set<ProcedureDto> procedures;
    private Set<DrugDto> drugs;

    public DiseaseDetailDto(Disease disease){
        this.id=disease.getId();
        this.name= disease.getName();
        this.diseaseClass = disease.getDiseaseClass();
        initSymptoms(disease);
        initProcedures(disease);
        initDrugs(disease);

    }

    private void initDrugs(Disease disease) {
        Set<Drug> drugSet = disease.getDrugs();
        if(CollectionUtils.isNotEmpty(drugSet)){
            this.drugs = drugSet.stream().map(DrugDto::new).collect(Collectors.toSet());
        }
    }

    private void initProcedures(Disease disease) {
        Set<Procedure> procedureSet =disease.getProcedures();
        if(CollectionUtils.isNotEmpty(procedureSet)){
            this.procedures = procedureSet.stream().map(ProcedureDto::new).collect(Collectors.toSet());
        }
    }

    private void initSymptoms(Disease disease) {
        Set<Symptom> symptomSet = disease.getSymptoms();
        if(CollectionUtils.isNotEmpty(symptomSet)){
            this.symptoms=symptomSet.stream().map(SymptomDto::new).collect(Collectors.toSet());
        }
    }

}
