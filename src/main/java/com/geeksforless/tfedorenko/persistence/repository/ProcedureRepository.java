package com.geeksforless.tfedorenko.persistence.repository;

import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedureRepository extends BaseRepository<Procedure>{

    List<Procedure> findAllByProcedureType (ProcedureType procedureType);

    @Query("SELECT  DISTINCT p.procedureType FROM Procedure as p where p.procedureType Is NOT NULL ")
    List<ProcedureType> findAllUniqueProcedureTypes();
}
