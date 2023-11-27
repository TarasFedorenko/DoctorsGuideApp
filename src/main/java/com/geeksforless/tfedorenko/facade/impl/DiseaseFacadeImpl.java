package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.DiseaseFacade;
import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.service.DiseaseService;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiseaseFacadeImpl implements DiseaseFacade {

    private  final DiseaseService diseaseService;
    @Override
    public List<DiseaseDto> findAll() {
        List<Disease> diseaseList = diseaseService.findAll();
        return diseaseList.stream().map(DiseaseDto::new).collect(Collectors.toList());
    }
}
