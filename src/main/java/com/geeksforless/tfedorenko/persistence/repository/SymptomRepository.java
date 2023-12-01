package com.geeksforless.tfedorenko.persistence.repository;

import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends BaseRepository<Symptom>{

    List<Symptom> findAllByType (SymptomType symptomType);

    @Query("SELECT  DISTINCT s.type FROM Symptom as s where s.type Is NOT NULL ")
    List<SymptomType> findAllUniqueSymptomTypes();
}
