package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.detail.DiseaseDetailDto;
import com.geeksforless.tfedorenko.web.dto.detail.DrugDetailDto;

import java.util.List;

public interface DrugFacade {
    List<DrugDto> getDrugByFirstLetter(String letter);
    DrugDetailDto findByName(String name);
    List<DrugDto> findAll();
    DrugDetailDto findById(Long id);
    void createDrug(Drug drug);
}
