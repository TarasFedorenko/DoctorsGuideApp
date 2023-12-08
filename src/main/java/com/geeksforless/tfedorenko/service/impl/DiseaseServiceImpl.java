package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.repository.DiseaseRepository;
import com.geeksforless.tfedorenko.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository diseaseRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<Disease> findById(Long id) {
        return diseaseRepository.findById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Disease> getDiseasesByFirstLetter(String letter) {
        return diseaseRepository.findByNameStartingWithIgnoreCase(letter);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Disease> findByName(String name) {
        return diseaseRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Disease> findAllByIds(List<Long> disease) {
        return diseaseRepository.findAllById(disease);
    }
}
