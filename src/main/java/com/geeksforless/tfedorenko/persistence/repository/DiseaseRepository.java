package com.geeksforless.tfedorenko.persistence.repository;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiseaseRepository extends BaseRepository<Disease> {

    List<Disease> findByNameStartingWithIgnoreCase(String letter);

    Optional<Disease> findByName(String name);

}
