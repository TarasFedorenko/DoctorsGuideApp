package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseService {

    Optional<Disease> findById(Long id);

    List<Disease> findAll();

    List<Disease> getDiseasesByFirstLetter(String letter);

    Optional<Disease> findByName(String name);
    List<Disease> findAllByIds(List<Long> disease);
}
