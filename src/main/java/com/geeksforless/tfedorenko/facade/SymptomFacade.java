package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.web.dto.SymptomDto;
import com.geeksforless.tfedorenko.web.dto.detail.SymptomDetailDto;

import java.util.List;

public interface SymptomFacade {

    List<SymptomDto> findAllByType(String typesName);
    List<String> findAllSymptomTypes();
    SymptomDetailDto findById(Long id);


}
