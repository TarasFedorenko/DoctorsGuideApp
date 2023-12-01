package com.geeksforless.tfedorenko.persistence.repository;

import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrugRepository extends BaseRepository<Drug>{
    List<Drug> findByNameStartingWithIgnoreCase(String letter);

    Optional<Drug> findByName(String name);
}
