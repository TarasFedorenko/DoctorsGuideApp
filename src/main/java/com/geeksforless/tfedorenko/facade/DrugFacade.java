package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.detail.DrugDetailDto;

import java.util.List;
import java.util.Set;

public interface DrugFacade {
    List<DrugDto> getDrugByFirstLetter(String letter);

    DrugDetailDto findByName(String name);

    List<DrugDto> findAll();

    DrugDetailDto findById(Long id);

    void createDrug(Drug drug);

    void addAnalogToTempList(Long id);

    Set<Drug> getTemporaryDrugs();

    Set<Disease> getTemporaryDiseases();

    void removeAnalogFromNewDrug(Long drugId);

    void addDiseaseToTempList(Long diseaseId);

    void removeDiseaseFromNewDrug(Long diseaseId);

    void updateDrug(Drug drug);

    void removeDrug(Long id);
}
