package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.repository.DoseRepository;
import com.geeksforless.tfedorenko.persistence.repository.DrugRepository;
import com.geeksforless.tfedorenko.service.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DrugServiceImpl implements DrugService{
    private final DrugRepository drugRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<Drug> findById(Long id) {
        return drugRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Drug> findAll() {
        return drugRepository.findAll();
    }
}