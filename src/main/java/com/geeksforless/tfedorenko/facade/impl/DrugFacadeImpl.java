package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.DrugFacade;
import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.service.DrugService;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.detail.DiseaseDetailDto;
import com.geeksforless.tfedorenko.web.dto.detail.DrugDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrugFacadeImpl implements DrugFacade {

    private final DrugService drugService;
    @Override
    public List<DrugDto> getDrugByFirstLetter(String letter) {
        List<Drug> drugList = drugService.getDrugByFirstLetter(letter);
        return drugList.stream().map(DrugDto::new).collect(Collectors.toList());
    }

    @Override
    public DrugDetailDto findByName(String name) {
        return drugService.findByName(name)
                .map(DrugDetailDto::new)
                .orElseThrow(() -> new RuntimeException("Drug not found"));
    }

    @Override
    public List<DrugDto> findAll() {
        List<Drug> drugList = drugService.findAll();
        return drugList.stream().map(DrugDto::new).collect(Collectors.toList());
    }

    @Override
    public DrugDetailDto findById(Long id) {
        Optional<Drug> drugOptional = drugService.findById(id);
        return drugOptional.map(DrugDetailDto::new).orElseThrow(()-> new RuntimeException("Drug not found"));
    }
}
