package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;

import java.util.List;
import java.util.Optional;

public interface ProcedureService {
    Optional<Procedure> findById(Long id);
    List<Procedure> findAll();
    List<Procedure> findAllByType(ProcedureType procedureType);
    List<ProcedureType> findAllProcedureTypes();


}
