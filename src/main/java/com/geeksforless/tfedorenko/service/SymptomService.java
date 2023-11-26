package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;

import java.util.List;
import java.util.Optional;

public interface SymptomService {
    Optional<Symptom> findById(Long id);
    List<Symptom> findAll();
}
