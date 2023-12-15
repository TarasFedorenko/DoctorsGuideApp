package com.geeksforless.tfedorenko.facade;

import com.geeksforless.tfedorenko.web.dto.ProcedureDto;
import com.geeksforless.tfedorenko.web.dto.detail.ProcedureDetailDto;


import java.util.List;

public interface ProcedureFacade {
    List<ProcedureDto> findAllByType(String procedureName);
    List<String> findAllProcedureTypes();
    ProcedureDetailDto findById(Long id);
}
