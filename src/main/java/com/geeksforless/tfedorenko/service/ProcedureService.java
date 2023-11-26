package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Procedure;

import java.util.List;
import java.util.Optional;

public interface ProcedureService {
    Optional<Procedure> findById(Long id);
    List<Procedure> findAll();
}
