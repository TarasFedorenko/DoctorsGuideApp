package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.repository.DoseRepository;
import com.geeksforless.tfedorenko.persistence.repository.ProcedureRepository;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;
import com.geeksforless.tfedorenko.service.ProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProcedureServiceImpl implements ProcedureService {
    private final ProcedureRepository procedureRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<Procedure> findById(Long id) {
        return procedureRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Procedure> findAll() {
        return procedureRepository.findAll();
    }

    @Override
    public List<Procedure> findAllByType(ProcedureType procedureType) {
        return procedureRepository.findAllByProcedureType(procedureType);
    }

    @Override
    public List<ProcedureType> findAllProcedureTypes() {
        return procedureRepository.findAllUniqueProcedureTypes();
    }
}
