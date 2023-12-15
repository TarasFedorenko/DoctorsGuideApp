package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.ProcedureFacade;
import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;
import com.geeksforless.tfedorenko.service.ProcedureService;
import com.geeksforless.tfedorenko.web.dto.ProcedureDto;
import com.geeksforless.tfedorenko.web.dto.detail.ProcedureDetailDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProcedureFacadeImpl implements ProcedureFacade {
    private final ProcedureService procedureService;

    @Override
    public List<ProcedureDto> findAllByType(String typesName) {
        List<Procedure> procedures = procedureService.findAllByType(ProcedureType.valueOf(typesName));
        return procedures.stream().map(ProcedureDto::new).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllProcedureTypes() {
        return procedureService.findAllProcedureTypes().stream()
                .map(ProcedureType::toString)
                .collect(Collectors.toList());
    }

    @Override
    public ProcedureDetailDto findById(Long id) {
        Optional<Procedure> procedureOptional = procedureService.findById(id);
        return procedureOptional.map(ProcedureDetailDto::new).orElseThrow(() -> new RuntimeException("Procedure not found"));
    }
}
