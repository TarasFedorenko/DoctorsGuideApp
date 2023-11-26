package com.geeksforless.tfedorenko.web.dto.detail;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Dose;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.type.DrugGroup;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.DoseDto;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class DrugDetailDto {

    private Long id;
    private String name;
    private String description;
    private String article;
    private DrugGroup drugGroup;
    private Integer quantity;
    Set<DrugDto> analogs;
    Set<DiseaseDto> diseases;
    Set<DoseDto> doses;

    public DrugDetailDto(Drug drug){
        this.id =drug.getId();
        this.name= drug.getName();
        this.description =drug.getDescription();
        this.article = drug.getArticle();
        this.drugGroup =drug.getDrugGroup();
        this.quantity = drug.getQuantity();
        initAnalogs(drug);
        initDiseases(drug);
        initDoses(drug);
    }

    private void initAnalogs(Drug drug) {
        Set<Drug> drugSet = drug.getAnalogs();
        if(CollectionUtils.isNotEmpty(drugSet)){
            this.analogs =drugSet.stream().map(DrugDto::new).collect(Collectors.toSet());
        }
    }

    private void initDiseases(Drug drug) {
        Set<Disease>diseaseSet = drug.getDiseases();
        if(CollectionUtils.isNotEmpty(diseaseSet)){
            this.diseases=diseaseSet.stream().map(DiseaseDto::new).collect(Collectors.toSet());
        }
    }

    private void initDoses(Drug drug) {
        Set<Dose> doseSet = drug.getDoses();
        if(CollectionUtils.isNotEmpty(doseSet)){
            this.doses = doseSet.stream().map(DoseDto::new).collect(Collectors.toSet());
        }
    }

}
