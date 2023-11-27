package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Disease;

import java.util.List;
import java.util.Optional;

public interface DiseaseService {

    Optional<Disease> findById(Long id);

    List<Disease> findAll();
}
