package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.repository.DrugRepository;
import com.geeksforless.tfedorenko.service.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    @Transactional(readOnly = true)
    public List<Drug> getDrugByFirstLetter(String letter) {
        return drugRepository.findByNameStartingWithIgnoreCase(letter);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Drug> findByName(String name) {
        return drugRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Drug> findAllByIds(List<Long> drugs) {
        return drugRepository.findAllById(drugs);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void saveDrug(Drug drug) {
        drugRepository.save(drug);

    }


}
