package com.geeksforless.tfedorenko.web.dto.detail;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
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
public class SymptomDetailDto extends SymptomDto {

    private SymptomType symptomType;
    private Set<DiseaseDto> diseases;

    public SymptomDetailDto(Symptom symptom) {
        super(symptom);
        this.symptomType = symptom.getType();
        initDisease(symptom);
    }

    private void initDisease(Symptom symptom) {
        Set<Disease> diseaseSet = symptom.getDiseases();
        if (CollectionUtils.isNotEmpty(diseaseSet)) {
            this.diseases = diseaseSet.stream().map(DiseaseDto::new).collect(Collectors.toSet());
        }
    }
}
