package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.repository.SymptomRepository;
import com.geeksforless.tfedorenko.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService {

    private final SymptomRepository symptomRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<Symptom> findById(Long id) {
        return symptomRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Symptom> findAll() {
        return symptomRepository.findAll();
    }
}
