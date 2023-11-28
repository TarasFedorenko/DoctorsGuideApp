package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.DiseaseFacade;
import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.service.DiseaseService;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.detail.DiseaseDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public DiseaseDetailDto findById(Long id) {
        Optional<Disease> optionalDisease = diseaseService.findById(id);
        if(optionalDisease.isPresent()){
            Disease disease = optionalDisease.get();
            return new DiseaseDetailDto(disease);
        }
        throw new RuntimeException("disease not found");
    }

    @Override
    public List<DiseaseDto> getDiseasesByFirstLetter(String letter) {
        List<Disease> diseaseList = diseaseService.getDiseasesByFirstLetter(letter);
        return diseaseList.stream().map(DiseaseDto::new).collect(Collectors.toList());
    }

    @Override
    public DiseaseDetailDto findByName(String name) {
        Optional<Disease> optionalDisease = diseaseService.findByName(name);
        if(optionalDisease.isPresent()){
            Disease disease = optionalDisease.get();
            return new DiseaseDetailDto(disease);
        }
        throw new RuntimeException("disease not found");
    }
}
