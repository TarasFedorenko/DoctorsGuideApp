package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DrugService {
    Optional<Drug> findById(Long id);
    List<Drug> findAll();
    List<Drug> getDrugByFirstLetter(String letter);
    Optional<Drug> findByName(String name);
    List<Drug> findAllByIds(List<Long>drugs);
    void saveDrug(Drug drug);
}
