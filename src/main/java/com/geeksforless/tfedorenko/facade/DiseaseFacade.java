package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.web.dto.DiseaseDto;

import java.util.List;

public interface DiseaseFacade {
    List<DiseaseDto> findAll();
}
