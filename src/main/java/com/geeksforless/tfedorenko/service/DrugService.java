package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;

import java.util.List;
import java.util.Optional;

public interface DrugService {
    Optional<Drug> findById(Long id);
    List<Drug> findAll();
}
