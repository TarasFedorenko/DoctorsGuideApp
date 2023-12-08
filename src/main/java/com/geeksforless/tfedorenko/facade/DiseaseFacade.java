package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.detail.DiseaseDetailDto;

import java.util.List;

public interface DiseaseFacade {
    List<DiseaseDto> findAll();

    DiseaseDetailDto findById(Long id);

    List<DiseaseDto> getDiseasesByFirstLetter(String letter);

    DiseaseDetailDto findByName(String name);

    List<Disease> findAllByIds(List<Long> disease);


}
