package com.geeksforless.tfedorenko.web.dto.detail;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class SymptomDetailDto {
    private Long id;
    private String name;
    private SymptomType symptomType;
    private Set<DiseaseDto> diseases;

    public SymptomDetailDto(Symptom symptom){
        this.id = symptom.getId();
        this.name =symptom.getName();
        this.symptomType =symptom.getType();
        initDisease(symptom);
    }

    private void initDisease(Symptom symptom) {
        Set<Disease> diseaseSet = symptom.getDiseases();
        if(CollectionUtils.isNotEmpty(diseaseSet)){
            this.diseases = diseaseSet.stream().map(DiseaseDto::new).collect(Collectors.toSet());
        }
    }
}
