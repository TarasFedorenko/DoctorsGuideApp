package com.geeksforless.tfedorenko.web.dto.detail;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DrugDetailDto extends DrugDto {

    private String description;
    private double doseValue;
    private String doseUnit;
    Set<DrugDto> analogs;
    Set<DiseaseDto> diseases;


    public DrugDetailDto(Drug drug) {
        super(drug);
        this.description = drug.getDescription();
        this.doseValue = drug.getDoseValue();
        this.doseUnit = drug.getDoseUnit();
        initAnalogs(drug);
        initDiseases(drug);
    }

    private void initAnalogs(Drug drug) {
        Set<Drug> drugSet = drug.getAnalogs();
        if (CollectionUtils.isNotEmpty(drugSet)) {
            this.analogs = drugSet.stream().map(DrugDto::new).collect(Collectors.toSet());
        }
    }

    private void initDiseases(Drug drug) {
        Set<Disease> diseaseSet = drug.getDiseases();
        if (CollectionUtils.isNotEmpty(diseaseSet)) {
            this.diseases = diseaseSet.stream().map(DiseaseDto::new).collect(Collectors.toSet());
        }
    }


}
