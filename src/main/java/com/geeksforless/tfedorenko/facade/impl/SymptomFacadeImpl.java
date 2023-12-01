package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.SymptomFacade;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;
import com.geeksforless.tfedorenko.service.SymptomService;
import com.geeksforless.tfedorenko.web.dto.SymptomDto;
import com.geeksforless.tfedorenko.web.dto.detail.SymptomDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SymptomFacadeImpl implements SymptomFacade {

    private final SymptomService symptomService;
    @Override
    public List<SymptomDto> findAllByType(String typesName) {
        List<Symptom> symptoms = symptomService.findAllByType(SymptomType.valueOf(typesName));
        return symptoms.stream().map(SymptomDto::new).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllSymptomTypes() {
        return symptomService.findAllSymptomTypes().stream()
                .map(SymptomType::toString)
                .collect(Collectors.toList());
    }

    @Override
    public SymptomDetailDto findById(Long id) {
        Optional<Symptom> symptomOptional = symptomService.findById(id);
        return symptomOptional.map(SymptomDetailDto::new).orElseThrow(()-> new RuntimeException("Symptom not found"));
    }
}
